/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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