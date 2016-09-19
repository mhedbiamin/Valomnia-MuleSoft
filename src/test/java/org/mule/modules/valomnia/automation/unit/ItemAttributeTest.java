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
import org.mule.modules.valomnia.entities.ItemAttribute;

public class ItemAttributeTest {

	@Test
	public void testSetterItemAttributeItemReference_setsProperly()
			throws NoSuchFieldException, IllegalAccessException {

		ItemAttribute itemAttribute = new ItemAttribute();

		itemAttribute.setItemReference("test item reference");

		final Field field = itemAttribute.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		assertEquals(field.get(itemAttribute), "test item reference");
	}

	@Test
	public void testSetterItemAttributeAttributeReference_setsProperly()
			throws NoSuchFieldException, IllegalAccessException {
		ItemAttribute itemAttribute = new ItemAttribute();

		itemAttribute.setAttributeReference("test attribute reference");

		Field field = itemAttribute.getClass().getDeclaredField("attributeReference");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(itemAttribute), "test attribute reference");
	}

	@Test
	public void testGetterItemAttributetItemReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final ItemAttribute itemAttribute = new ItemAttribute();

		Field field = itemAttribute.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		field.set(itemAttribute, "test item reference");

		final String result = itemAttribute.getItemReference();

		assertEquals("field wasn't retrieved properly", result, "test item reference");
	}

	@Test
	public void testItemsAttributeAreEqual() {

		ItemAttribute itemAttribute = new ItemAttribute();
		itemAttribute.setItemReference("test reference");
		itemAttribute.setAttributeReference("attributeReference");
		itemAttribute.setValue("Value");

		assertEquals(itemAttribute.getAttributeReference(), "attributeReference");
		assertEquals(itemAttribute.getValue(), "Value");

	}

}
