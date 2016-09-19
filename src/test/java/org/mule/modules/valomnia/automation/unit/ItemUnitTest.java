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

import org.mule.modules.valomnia.entities.ItemUnit;

public class ItemUnitTest {

	@Test
	public void testSetterItemUnitItemReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		ItemUnit itemUnit = new ItemUnit();

		itemUnit.setItemReference("test item reference");

		final Field field = itemUnit.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		assertEquals(field.get(itemUnit), "test item reference");
	}

	@Test
	public void testSetterItemUnitUnitReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		ItemUnit itemUnit = new ItemUnit();

		itemUnit.setUnitReference("test unit reference");

		Field field = itemUnit.getClass().getDeclaredField("unitReference");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(itemUnit), "test unit reference");
	}

	@Test
	public void testGetterItemUnitItemReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final ItemUnit itemUnit = new ItemUnit();

		Field field = itemUnit.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		field.set(itemUnit, "test  item reference");

		final String result = itemUnit.getItemReference();

		assertEquals("field wasn't retrieved properly", result, "test  item reference");
	}

	@Test
	public void testItemGetters() {

		ItemUnit itemUnit = new ItemUnit();
		itemUnit.setItemReference("test item reference");
		itemUnit.setUnitReference("test unit reference");
		itemUnit.setQuantity("7");
		itemUnit.setSalesQty("8");
		itemUnit.setBarcode("A34");

		assertEquals(itemUnit.getQuantity(), "7");
		assertEquals(itemUnit.getUnitReference(), "test unit reference");
		assertEquals(itemUnit.getSalesQty(), "8");
		assertEquals(itemUnit.getBarcode(), "A34");

	}

}