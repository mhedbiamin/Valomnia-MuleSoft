/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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
