/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Item;

public class ItemTest {

	
	@Test
	public void testItemsAreEqual() {
		
		Item item = new Item ();
		item.setReference("test reference");
		item.setCategoryReference("drinks");
		item.setName("item test");
		
		Item item1 = new Item ();
		item1.setReference("test reference");
		item1.setCategoryReference("drinks");
		item1.setName("item test");
		
		
		assertEquals(item,item1);
		
	}
	
	@Test
	public void testItemsAreNotEqual() {
		
		Item item = new Item ();
		item.setReference("test reference");
		item.setCategoryReference("drinks");
		item.setName("item test");
		
		Item item1 = new Item ();
		item1.setReference("test reference1");
		item1.setCategoryReference("drinks");
		item1.setName("item test1");
		
		
		assertFalse(item.equals(item1));
		
	}
	
	
	
}