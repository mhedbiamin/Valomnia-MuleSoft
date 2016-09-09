package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.ItemUnit;

public class ItemUnitTest {

	@Test
	public void testItemsAreEqual() {
		
		ItemUnit itemUnit = new ItemUnit ();
		itemUnit.setItemReference("test item reference");
		itemUnit.setUnitReference("test unit reference");
		itemUnit.setQuantity("7");
		
		ItemUnit itemUnit1 = new ItemUnit ();
		itemUnit1.setItemReference("test item reference");
		itemUnit1.setUnitReference("test unit reference");
		itemUnit1.setQuantity("7");
		
		assertEquals(itemUnit,itemUnit1);
		
	}
	
	@Test
	public void testItemsAreNotEqual() {
		
		ItemUnit itemUnit = new ItemUnit ();
		itemUnit.setItemReference("test item reference");
		itemUnit.setUnitReference("test unit reference");
		itemUnit.setQuantity("7");
		
		ItemUnit itemUnit1 = new ItemUnit ();
		itemUnit1.setItemReference("test item reference");
		itemUnit1.setUnitReference("test unit reference1");
		itemUnit1.setQuantity("8");
		
		assertFalse(itemUnit.equals(itemUnit1));
		
	}
	
}