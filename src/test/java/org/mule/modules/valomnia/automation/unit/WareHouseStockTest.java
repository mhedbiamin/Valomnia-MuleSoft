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
import org.mule.modules.valomnia.entities.WareHouseStock;

public class WareHouseStockTest {

	@Test
	public void testSetterWareHouseStockWareHouseReference_setsProperly()
			throws NoSuchFieldException, IllegalAccessException {

		WareHouseStock wareHouseStock = new WareHouseStock();

		wareHouseStock.setWarehouseReference("test  wareHouse reference");

		final Field field = wareHouseStock.getClass().getDeclaredField("warehouseReference");
		field.setAccessible(true);
		assertEquals(field.get(wareHouseStock), "test  wareHouse reference");
	}

	@Test
	public void testSetterWareHouseStockItemReference_setsProperly()
			throws NoSuchFieldException, IllegalAccessException {
		WareHouseStock wareHouseStock = new WareHouseStock();

		wareHouseStock.setItemReference("test item reference");

		final Field field = wareHouseStock.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);

		assertEquals("Fields didn't match", field.get(wareHouseStock), "test item reference");
	}

	@Test
	public void testGetterWareHouseStockItemReference() throws NoSuchFieldException, IllegalAccessException {

		WareHouseStock wareHouseStock = new WareHouseStock();

		Field field = wareHouseStock.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		field.set(wareHouseStock, "test item reference");

		final String result = wareHouseStock.getItemReference();

		assertEquals("field wasn't retrieved properly", result, "test item reference");
	}

	@Test
	public void testWareHousesStockGetters() {

		WareHouseStock wareHouseStock = new WareHouseStock();
		wareHouseStock.setWarehouseReference("test WareHouse reference");
		wareHouseStock.setItemReference("item reference");
		wareHouseStock.setUnitReference("unit reference");
		wareHouseStock.setQuantity("34");

		assertEquals(wareHouseStock.getQuantity(), "34");
		assertEquals(wareHouseStock.getUnitReference(), "unit reference");

	}

}
