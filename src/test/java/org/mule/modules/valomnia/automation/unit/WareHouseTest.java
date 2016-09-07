package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.WareHouse;

public class WareHouseTest {
	@Test
	public void testWareHousesAreEqual() {
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setReference("test reference");
		wareHouse.setEmployeeReference("employee reference");
		wareHouse.setName("wareHouse name");
		
		WareHouse wareHouse1 = new WareHouse();
		wareHouse1.setReference("test reference");
		wareHouse1.setEmployeeReference("employee reference");
		wareHouse1.setName("wareHouse name");
		
		assertEquals(wareHouse,wareHouse1);
		
	}
	
	@Test
	public void testWareHousesAreNotEqual() {
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setReference("test reference");
		wareHouse.setEmployeeReference("employee reference");
		wareHouse.setName("wareHouse name");
		
		WareHouse wareHouse1 = new WareHouse();
		wareHouse1.setReference("test reference1");
		wareHouse1.setEmployeeReference("employee reference");
		wareHouse1.setName("wareHouse name1");
		
		
		assertFalse(wareHouse.equals(wareHouse1));
		
	}
}
