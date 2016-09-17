/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Field;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Contact;

public class ContactTest {

	@Test
	public void testSetterContactFirstName_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		Contact contact = new Contact();

		contact.setFirstName("test FirstName");

		final Field field = contact.getClass().getDeclaredField("firstName");
		field.setAccessible(true);
		assertEquals(field.get(contact), "test FirstName");
	}

	@Test
	public void testSetterContactAdress_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		Contact contact = new Contact();

		contact.setAddress("test address");

		Field field = contact.getClass().getDeclaredField("address");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(contact), "test address");
	}

	@Test
	public void testGetterContactAdress_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Contact contact = new Contact();

		Field field = contact.getClass().getDeclaredField("address");
		field.setAccessible(true);
		field.set(contact, "test address");

		final String result = contact.getAddress();

		assertEquals("field wasn't retrieved properly", result, "test address");
	}

	@Test
	public void testGettersContact() {

		Contact contact = new Contact();

		contact.setFirstName("test first name");
		contact.setEmail("email@test.com");
		contact.setLastName("test Last name");
		contact.setAddress("test address");
		contact.setCity("tunisia");
		contact.setFonction("comercial");
		contact.setCustomerReference("test customer reference");
		

		
		assertEquals(contact.getFirstName(),"test first name" );
		assertEquals(contact.getLastName(),"test Last name" );
		assertEquals(contact.getAddress(),"test address" );
		assertEquals(contact.getCity(),"tunisia" );
		assertEquals(contact.getEmail(),"email@test.com");
		assertEquals(contact.getFonction(),"comercial");
		assertEquals(contact.getCustomerReference(),"test customer reference");
		
		

	}


}
