/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.client.ValomniaClientProvider;
import org.mule.modules.valomnia.client.impl.ValomniaClientProviderImpl;
import org.mule.modules.valomnia.core.ConnectorConfig;
import org.mule.modules.valomnia.entities.Item;

public class ConfigTest {

	
	
	@Test 
	public void config(){
		ConnectorConfig config=new ConnectorConfig();
		ValomniaClientProvider clientProvider=new ValomniaClientProviderImpl("valomnia",
				"token");
		config.setClientProvider(clientProvider);
		ValomniaClientProviderImpl client=(ValomniaClientProviderImpl) config.getClientProvider();
	 
		
		ValomniaConnector val= new ValomniaConnector();
		val.setConfig(config);
		try {
			client.getClient(Item.class).getAll();
        } catch (Exception e) {
            assertEquals("NullPointerException", e.getMessage());
		
    
	}
	}}

