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

