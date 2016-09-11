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
