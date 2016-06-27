/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.modules.valomnia.client.ValomniaClientProvider;
import org.mule.modules.valomnia.client.impl.ValomniaClientProviderImpl;
import com.google.gson.Gson;

@ConnectionManagement(configElementName = "config", friendlyName = "Configuration")
public class ConnectorConfig {
	private static final Logger logger = Logger
			.getLogger(ConnectorConfig.class);
	private String token;
	private String user;
	private String password;
	private String baseUrl;
	private ValomniaClientProvider clientProvider;

	public ValomniaClientProvider getClientProvider() {
		return clientProvider;
	}

	public void setClientProvider(ValomniaClientProvider clientProvider) {
		this.clientProvider = clientProvider;
	}

	/**
	 * Connect
	 *
	 * @param username
	 *            a username
	 * @param password
	 *            a password
	 * @param baseUrl
	 *            a baseUrl of Valomnia API
	 * 
	 * @throws ConnectionException
	 *             if the username or password incorrect
	 */
	@Connect
	@TestConnectivity
	public void connect(@ConnectionKey String username,
			@Password String password, String baseUrl)
			throws ConnectionException {
		if (!(baseUrl.endsWith("/"))) {
			baseUrl += "/";
		}
		this.user = username;
		this.password = password;
		this.baseUrl = baseUrl;
		this.token = getAuthToken();
		if (token != null) {
			setClientProvider(new ValomniaClientProviderImpl(baseUrl,
					token));
		} else {
			throw new ConnectionException(
					ConnectionExceptionCode.INCORRECT_CREDENTIALS,
					"invalid credentials", "Invalid credentials");
		}
	}

	/**
	 * Disconnect
	 */
	@Disconnect
	public void disconnect() {
		setClientProvider(null);
	}

	/**
	 * Are we connected
	 */
	@ValidateConnection
	public boolean isConnected() {
		return getClientProvider() != null;
	}

	/**
	 * Id used when debuging.
	 */
	@ConnectionIdentifier
	public String connectionId() {
		return token;
	}

	public String getAuthToken() {

		return authentication(this.user, this.password);

	}

	public static String encodage(final List<CustomNameValuePair> parameters) {
		return URLEncodedUtils.format(parameters, "ISO-8859-1");
	}

	public String authentication(final String login, final String password) {

		String test = null;
		try {

			final DefaultHttpClient client = new DefaultHttpClient();

			final List<CustomNameValuePair> parameters = new ArrayList<CustomNameValuePair>();
			parameters.add(new CustomNameValuePair("j_username", login));
			parameters.add(new CustomNameValuePair("j_password", password));
			parameters.add(new CustomNameValuePair("ajax", "true"));

			final String url = encodage(parameters);

			final HttpPost post = new HttpPost(getBaseUrl()
					+ "j_spring_security_check?" + url);

			post.setHeader("Content-type", "application/json");

			final HttpResponse response = client.execute(post);
			HttpResponse response2 = null;

			if (response.getStatusLine().getStatusCode() == 302) {

				final String loc = response.getFirstHeader("Location")
						.getValue();

				final String cookie = response.getFirstHeader("Set-Cookie")
						.getValue();
				final String token1 = cookie.substring(11, cookie.indexOf(";"));

				if (loc != null) {

					final DefaultHttpClient client2 = new DefaultHttpClient();

					final HttpPost post2 = new HttpPost(loc);
					post2.setHeader("Content-type",
							"application/json;charset=UTF-8");
					post2.setHeader("Cookie", "JSESSIONID=" + token1);
					response2 = client2.execute(post2);

				}

			}

			if (response2.getStatusLine().getStatusCode() != 200) {
				System.out.println("Failed : HTTP error code : "
						+ response2.getStatusLine().getStatusCode());
			} else {

				final BufferedReader reader = new BufferedReader(
						new InputStreamReader(response2.getEntity()
								.getContent()));

				final String line = reader.readLine();
				if (line != null) {

					@SuppressWarnings("unchecked")
					final Map<String, Object> javaRootMapObject = new Gson()
							.fromJson(line, Map.class);
					if (javaRootMapObject != null
							&& javaRootMapObject.get("token") != null) {

						test = javaRootMapObject.get("token").toString();

					}
				}

			}
		} catch (HttpHostConnectException e) {
			test = "HttpHostConnectException";
			logger.error("Http exception", e);
		} catch (Exception cpe) {
			logger.error("Http exception", cpe);
		}

		return test;

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}