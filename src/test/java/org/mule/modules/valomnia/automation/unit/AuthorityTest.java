/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
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