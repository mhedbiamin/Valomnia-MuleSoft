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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.mule.modules.valomnia.client.*;
import org.mule.modules.valomnia.core.CustomNameValuePair;
import org.mule.util.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.*;

public class GenericValomniaClientImpl<T> extends AbstractValomniaClient<T>
		implements GenericValomniaClient<T> {

	private final Class<T> typeElement;
	private final String token;

	private final String resourcePath;

	private static final Logger logger = Logger
			.getLogger(GenericValomniaClient.class);

	/* Map of the request parameters */
	

	public GenericValomniaClientImpl(String baseUrl, String token,
			String resourcePath, Class<T> typeElement) {
		super(baseUrl);
		this.token = token;
		this.typeElement = typeElement;

		this.resourcePath = resourcePath;

	}

	public String getToken() {
		return this.token;
	}

	

	@Override
	protected StringBuilder extendGetBaseUrl(final StringBuilder baseUrl) {

		return baseUrl.append(this.resourcePath);

	}

	@Override
	public List<T> getAll() {

		List<T> results = new ArrayList<T>();

		try {

			final List<CustomNameValuePair> parameters = new ArrayList<CustomNameValuePair>();

			parameters.add(new CustomNameValuePair("firstSynchronization",
					"true"));

			parameters.add(new CustomNameValuePair("format", "json"));

			final String url = encodage(parameters);

			final HttpResponse response = getResponse("get", this.getToken(),
					getBaseURL() + "list?" + url);
			results = this.processResponse(response);

		} catch (IOException e) {

			logger.error("Http client exception ", e);
		} catch (Exception e) {

			logger.error("Http exception", e);

		}

		return (ArrayList<T>) results;

	}

	/**
	 * this method process the response from Valomnia API
	 * 
	 * @param response
	 *            returned by the invocation
	 * @return List of entities , null if not found, or an Exception if
	 *         something bad happened
	 * @throws Exception
	 */

	public List<T> processResponse(final HttpResponse response)
			throws ValomniaAPIException {

		List<T> entities = null;
		final String line = readResponseFromClientResponse(response);

		if (response.getStatusLine().getStatusCode() == 404) {

			throw new ValomniaAPIException("ressource not found");

		} else if (response.getStatusLine().getStatusCode() >= 400) {

			throw new ValomniaAPIException(line);

		}
		final List<T> results = new ArrayList<T>();
		try {

			entities = new ArrayList<T>();
			if (line != null) {

				JsonArray list = parseToJson(line, "listCreated");

				entities = parseFromJson(list, typeElement);
				results.addAll(entities);
				JsonArray list1 = parseToJson(line, "listUpdated");
				entities = parseFromJson(list1, typeElement);
				results.addAll(entities);

			} else {
				logger.error(" HTTP  code : "
						+ response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {

			logger.error("Http execption", e);
		}
		return results;

	}

	@Override
	public String merge(final Object object) {
		String result = null;
		String line;
		int saved;
		HttpResponse response = null;

		String params=null;

		try {

			final List<CustomNameValuePair> parameters = new ArrayList<CustomNameValuePair>();

			saved = this.getAll().size();

			@SuppressWarnings("unchecked")
			final Map<String, Object> map = BeanUtils.describe(object);

			for (final Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null) {
					parameters.add(new CustomNameValuePair(entry.getKey(),
							(String) entry.getValue()));
				}

			}

			params = encodage(parameters);

			try {
				response = getResponse("post", this.getToken(), getBaseURL()
						+ "saveOrUpdate?" + params);
			} catch (Exception e) {
				logger.error("Http execption", e);
				
			}

			if (response.getStatusLine().getStatusCode() == 200) {

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));

				int saved1 = this.getAll().size();
				line = rd.readLine();

				if (line != null) {
					if (saved != saved1) {
						result = "Success created";
					} else {
						result = "Success Updated";
					}
				}

			} else {

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				line = rd.readLine();
				if (line != null) {

					@SuppressWarnings("unchecked")
					ArrayList<Object> errorsResponse = new Gson().fromJson(
							line, ArrayList.class);

					Type type = new TypeToken<List<String>>() {
					}.getType();

					String Temp = new Gson().toJson(errorsResponse);
					List<String> errors = new Gson().fromJson(Temp, type);
					result = errors.get(0) + errors.get(1);
				}

			}
		} catch (ClientProtocolException e) {
			logger.error("Http client exception", e);

		} catch (IOException e) {

			logger.error("Http client exception ", e);
		}

		return result;

	}

}
