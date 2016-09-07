package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.WareHouseStock;

public class WareHouseStockTest {
	@Test
	public void testWareHousesStockAreEqual() {
		
		WareHouseStock wareHouseStock = new WareHouseStock();
		wareHouseStock.setWarehouseReference("test WareHouse reference");
		wareHouseStock.setItemReference("item reference");
		wareHouseStock.setUnitReference("unit reference");
		
		WareHouseStock wareHouseStock1 = new WareHouseStock();
		wareHouseStock1.setWarehouseReference("test WareHouse reference");
		wareHouseStock1.setItemReference("item reference");
		wareHouseStock1.setUnitReference("unit reference");
		
		assertEquals(wareHouseStock,wareHouseStock1);
		
	}
	
	@Test
	public void testWareHousesStockAreNotEqual() {
		
		WareHouseStock wareHouseStock = new WareHouseStock();
		wareHouseStock.setWarehouseReference("test WareHouse1 reference");
		wareHouseStock.setItemReference("item reference1");
		wareHouseStock.setUnitReference("unit reference");
		
		WareHouseStock wareHouseStock1 = new WareHouseStock();
		wareHouseStock1.setWarehouseReference("test WareHouse reference");
		wareHouseStock1.setItemReference("item reference");
		wareHouseStock1.setUnitReference("unit reference");
		
		assertFalse(wareHouseStock.equals(wareHouseStock1));
		
	}
}
