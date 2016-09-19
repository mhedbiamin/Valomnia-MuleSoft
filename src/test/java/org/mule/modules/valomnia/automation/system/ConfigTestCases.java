/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.system;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.modules.valomnia.core.ConnectorConfig;
import org.mule.tools.devkit.ctf.configuration.util.ConfigurationUtils;
import org.mule.tools.devkit.ctf.exceptions.ConfigurationLoadingFailedException;

public class ConfigTestCases {

    private ConnectorConfig client;
    private Properties credentials;
    private String username;
    private String password;
    private String baseUrl;

    @Before
    public void setUp() throws ConnectionException, ConfigurationLoadingFailedException {

        credentials = ConfigurationUtils.getAutomationCredentialsProperties();
        username = credentials.getProperty("config.username");
        password = credentials.getProperty("config.password");
        baseUrl = credentials.getProperty("config.baseUrl");
        client = new ConnectorConfig();
        client.setUser(username);
        client.setPassword(password);
        client.setBaseUrl(baseUrl);

    }

    @Test
    public void shouldLoggedCorrectly() throws ConnectionException {
        try {
            ConnectorConfig config = new ConnectorConfig();
            config.connect(username, password, baseUrl);
        } catch (Exception e)
        {
            fail(e.getMessage());

        }

    }

    @Test
    public void shouldFailLogin() {
        ConnectorConfig config = new ConnectorConfig();

        try {
            config.connect("wronguser", "wrongpassword", baseUrl);
        } catch (ConnectionException e) {
            assertEquals(ConnectionExceptionCode.INCORRECT_CREDENTIALS, e.getCode());
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
   

}