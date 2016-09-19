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
