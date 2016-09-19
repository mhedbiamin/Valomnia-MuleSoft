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
import org.mule.modules.valomnia.entities.Authority;

public class AuthorityTest {

	@Test
	public void testSetterAuthorityName_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		Authority authority = new Authority();

		authority.setName("authority test");

		final Field field = authority.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals(field.get(authority), "authority test");
	}

	@Test
	public void testGetterAuthorityName_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Authority authority = new Authority();

		Field field = authority.getClass().getDeclaredField("name");
		field.setAccessible(true);
		field.set(authority, "authority test");

		final String result = authority.getName();

		assertEquals("field wasn't retrieved properly", result, "authority test");
	}

}