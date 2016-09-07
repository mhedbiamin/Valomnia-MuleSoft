package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.ItemAttribute;

public class ItemAttributeTest {

	
	@Test
	public void testItemsAttributeAreEqual() {
		
		ItemAttribute itemAttribute = new ItemAttribute ();
		itemAttribute.setItemReference("test reference");
		itemAttribute.setAttributeReference("attributeReference");
		itemAttribute.setValue("Value");
		
		ItemAttribute itemAttribute1 = new ItemAttribute ();
		itemAttribute1.setItemReference("test reference");
		itemAttribute1.setAttributeReference("attributeReference");
		itemAttribute1.setValue("Value");
				
		
		assertEquals(itemAttribute,itemAttribute1);
		
	}
	
	@Test
	public void testItemsAreNotEqual() {
		
		ItemAttribute itemAttribute = new ItemAttribute ();
		itemAttribute.setItemReference("test reference");
		itemAttribute.setAttributeReference("attributeReference");
		itemAttribute.setValue("Value");
		
		ItemAttribute itemAttribute1 = new ItemAttribute ();
		itemAttribute1.setItemReference("test reference1");
		itemAttribute1.setAttributeReference("attributeReference");
		itemAttribute1.setValue("Value");		
		
		
		assertFalse(itemAttribute.equals(itemAttribute1));
		
	}
	
}
