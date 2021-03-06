/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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

