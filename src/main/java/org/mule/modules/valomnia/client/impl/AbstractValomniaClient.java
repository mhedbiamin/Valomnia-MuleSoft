/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.mule.modules.valomnia.core.CustomNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;


/**
 * Base class for client service . The class handles:
 * 
 * base URL creation creation of the Http(Post/Get) read response from input
 * HttpResponse string Json-formated parsing to object Java Map parsing to
 * String Json-formated
 * 
 */

public abstract class AbstractValomniaClient<T> {

	public AbstractValomniaClient(String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}
     private static final Logger logger = Logger.getLogger(AbstractValomniaClient.class);
	private  String baseUrl;
	private static String encodage = "ISO-8859-1";
	protected Gson gson = null;
	private DefaultHttpClient client;

	/**
	 * @return the base URL for the service, inclduing what is added by {
	 *         AbstractValomniaClient#extendGetBaseUrl(StringBuilder)}
	 */

	protected String getBaseURL() {

		return this.extendGetBaseUrl(new StringBuilder(this.baseUrl))
				.toString();
	}

	/**
	 * This method is called by getBaseURL for the user to extend the base URL
	 *
	 * 
	 * @param baseUrl
	 *            a String builder with the Base Url
	 * @return the builder, with the extended content as needed
	 */

	protected abstract StringBuilder extendGetBaseUrl(
			final StringBuilder baseUrl);

	protected String readResponseFromClientResponse(final HttpResponse response) {

		String line = null;
		try {
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			line = rd.readLine();
			if (line != null) {
				line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("coding exception",e);
		}

		catch (final IOException e) {
			logger.error("input output exception",e);
		}
		return line;
	}

	public static String encodage(final List<CustomNameValuePair> parameters) {
		return URLEncodedUtils.format(parameters, encodage);
	}

	/**
	 * Creates and execute a Http request
	 * 
	 * @param type
	 *            of Http request(Get or Post)
	 * @param token
	 *            for authentication
	 * @param url
	 *            the URL to be hit by the client
	 * @throws IOException
	 *             when error happened in method execute
	 * @return HttpRespnse.
	 * 
	 */

	protected HttpResponse getResponse(final String type, final String token,
			final String url) throws IOException

	{
		HttpResponse response = null;
		if (type.equals("get")) {
			client = new DefaultHttpClient();
			final HttpGet get = new HttpGet(url);
			get.setHeader("Cookie", "JSESSIONID=" + token);
			response = client.execute(get);
		} else {

			client = new DefaultHttpClient();
			final HttpPost post = new HttpPost(url);

			post.setHeader("Content-type", "application/json;charset=UTF-8");

			if (token != null) {
				post.setHeader("Cookie", "JSESSIONID=" + token);
				response = client.execute(post);
			}
		}
		return response;

	}

	/**
	 * Parse JSON to specified  List entity type
	 *
	 * @param Class<T> Type 
	 *            of the entity to obtain
	 * @param JsonArray
	 *            JSON-formatted Array to parse
	 * @return  List<T> parsed  entities List 
	 * @throws IOException
	 *             if the string is not JSON-formatted
	 */
	 @SuppressWarnings("hiding")
	protected  <T> List<T> parseFromJson(final JsonArray array, final Class<T> clazz) 
				throws IOException {

			try {
				gson = new Gson();
				
				
				List<T> lst =  new ArrayList<T>();
		        for(final JsonElement json: array){
		            T entity = gson.fromJson(json, clazz);
		            lst.add(entity);
		        }

		        return lst;

			} catch (final JsonParseException jpe) {
				logger.error("Json exception",jpe);
				final IOException ioe = new IOException(
						"Parse exception  JSON to object");
				throw ioe;
			}

		}


	

	/**
	 * Parse JAVA String  to JsonArray  
	 *
	 * @param response  String to parse
	 * @param listName for specify the list name
	 * @return JsonArray  formated
	 * @throws IOException
	 *             if something happened in parsing
	 */

	
	
	protected JsonArray parseToJson(final String response ,
			final String  listName) throws IOException

	{   JsonParser parser = new JsonParser();
	JsonArray array=null;
		try {
			
			
			JsonObject jsonObject = (JsonObject)  parser.parse(response);
		    array=(JsonArray) jsonObject.get(listName);
			 
			
		} catch (final JsonParseException jpe) {
			logger.error("Json exeception",jpe);
			final IOException ioe = new IOException(
					"Parse exception converting Object to Json");

			throw ioe;
		}
		return  array;
	}
	

	public  void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
