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
import org.mule.modules.valomnia.entities.Item;

public class ItemTest {

	@Test
	public void testSetterItemReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		Item item = new Item();

		item.setReference("test reference");

		final Field field = item.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		assertEquals(field.get(item), "test reference");
	}

	@Test
	public void testSetterItemCategory_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		Item item = new Item();

		item.setCategoryReference("test category Reference");

		Field field = item.getClass().getDeclaredField("categoryReference");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(item), "test category Reference");
	}

	@Test
	public void testGetterItemReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Item item = new Item();

		Field field = item.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		field.set(item, "test reference");

		final String result = item.getReference();

		assertEquals("field wasn't retrieved properly", result, "test reference");
	}
	@Test
	public void testItemSetters_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Item item = new Item();

		item.setDescription("test description");
		item.setIsActive("True");
		item.setParentReference("item parent reference");
		item.setName("test name");
		assertEquals(item.getDescription(), "test description");
		assertEquals(item.getParentReference(),"item parent reference");
		assertEquals(item.getName(),"test name");
		
		assertEquals(item.getIsActive(),"True");

	}
	

	

}