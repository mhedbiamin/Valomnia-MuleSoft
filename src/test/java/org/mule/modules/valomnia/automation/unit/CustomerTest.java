/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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
