/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

 package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.mule.modules.valomnia.client.impl.AbstractValomniaClient;
import org.mule.modules.valomnia.client.impl.GenericValomniaClientImpl;
import org.mule.modules.valomnia.entities.Item;

import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;

public class AbstractValomniaClientTest {

	@Test
	public void testParseFromJsonArrayJsonParseException()

	{

		boolean thrown = false;
		@SuppressWarnings("unused")
		List<Item> response;

		try {

			response = AbstractValomniaClient.parseFromJson(new JsonArray(),
					Item.class);

		} catch (JsonParseException e) {
			thrown = true;

			assertTrue(thrown);
		}
	}

	@Test
	public void testGetResponseThrownHttpException() throws Exception

	{

		boolean thrown = false;
		@SuppressWarnings("unused")
		HttpResponse response;

		try {

			response = AbstractValomniaClient.getResponse("get", "token",
					"valomnia.test.com");

		} catch (HttpException e) {
			thrown = true;
		} catch (IOException e) {
			thrown = true;
		}

		catch (IllegalStateException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	
	@Test 
	
	
	public void testExtendGetBaseUrl()
	{
		String baseUrl="http://testUrl.com/";
	AbstractValomniaClient<Item>  obj= new  GenericValomniaClientImpl<Item>(baseUrl, null ,
				"items",  null);
		String result=obj.getBaseURL();
		assertEquals(result,"http://testUrl.com/items");
				
	}	
		
		@Test
		public  void testGetResponseWithNoToken() throws Exception
		
		
		{    GenericValomniaClientImpl<Item> obj=   new  GenericValomniaClientImpl<Item>("http;//testUrl.com/", null ,
				"items",  null);
			
			assertNull( obj.getResponse("post", obj.getToken(), obj.getBaseURL()));
		}
		
	}

