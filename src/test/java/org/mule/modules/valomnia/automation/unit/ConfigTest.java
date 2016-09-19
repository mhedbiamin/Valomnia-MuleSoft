/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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

