/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Customer;
public class CustomerTest {

	
	
	@Test
	public void testSetterCustomerReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		Customer customer = new Customer();

		customer.setReference("test reference");
		customer.setPhone("56645676");

		final Field field = customer.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		assertEquals(field.get(customer), "test reference");
	}

	@Test
	public void testSetterCustomerCategory_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		Customer customer = new Customer();

		customer.setCategoryReference("test category Reference");

		Field field = customer.getClass().getDeclaredField("categoryReference");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(customer), "test category Reference");
	}

	@Test
	public void testGetterCustomerReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Customer customer = new Customer();

		Field field = customer.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		field.set(customer, "test reference");

		final String result = customer.getReference();

		assertEquals("field wasn't retrieved properly", result, "test reference");
	}

	@Test
		public void testCustomersGetters() {
			
			Customer  customer = new Customer();
			
			customer.setReference("test reference");
			customer.setEmail("email@test.com");
			customer.setName("customer test");
			customer.setAddress("test adress");
			customer.setUserReference("test user");
			customer.setComment("test comment");
			
			customer.setCity("city");
			assertEquals(customer.getEmail(),"email@test.com" );
			assertEquals(customer.getComment(),"test comment" );
			assertEquals(customer.getAddress(),"test adress" );
			assertEquals(customer.getUserReference(),"test user" );
			assertEquals(customer.getName(),"customer test" );
			
			
			
		}
		
		
		
		
	}
