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
import org.mule.modules.valomnia.entities.ItemCategory;

public class ItemCategoryTest {

	@Test
	public void testSetterItemCategoryReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		ItemCategory itemCategory = new ItemCategory();

		itemCategory.setReference("test reference");

		final Field field = itemCategory.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		assertEquals(field.get(itemCategory), "test reference");
	}

	@Test
	public void testSetterItemCategoryName_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		ItemCategory itemCategory = new ItemCategory();

		itemCategory.setName("test Name");

		Field field = itemCategory.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(itemCategory), "test Name");
	}

	@Test
	public void testGetterItemCategoryReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		ItemCategory itemCategory = new ItemCategory();

		Field field = itemCategory.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		field.set(itemCategory, "test reference");

		final String result = itemCategory.getReference();

		assertEquals("field wasn't retrieved properly", result, "test reference");
	}

	@Test
	public void testItemCategoryGetters() {

		ItemCategory itemCategory = new ItemCategory();

		itemCategory.setReference("test reference");
		itemCategory.setDescription("test ItemCategory");
		itemCategory.setName("test name");
		itemCategory.setParentReference("parentReference");

		assertEquals(itemCategory.getDescription(), "test ItemCategory");
		assertEquals(itemCategory.getParentReference(), "parentReference");
		assertEquals(itemCategory.getName(), "test name");

	}

}
