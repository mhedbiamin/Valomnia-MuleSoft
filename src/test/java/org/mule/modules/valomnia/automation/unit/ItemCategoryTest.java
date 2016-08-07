/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mule.modules.valomnia.entities.ItemCategory;

public class ItemCategoryTest {



	@Test
	public void testItemCategoryAreEqual() {
		
		ItemCategory  itemCategory = new ItemCategory();
		
		itemCategory.setReference("test reference");
		itemCategory.setDescription("test ItemCategory");
		itemCategory.setName("test name");
		
		ItemCategory  itemCategory1 = new ItemCategory();
		
		itemCategory1.setReference("test reference");
		itemCategory1.setDescription("test ItemCategory");
		itemCategory1.setName("test name");
		
		
		assertEquals(itemCategory,itemCategory1);
		
	}
	
	@Test
	public void testItemCategoryAreNotEqual() {
		ItemCategory  itemCategory = new ItemCategory();
		
		itemCategory.setReference("test reference");
		itemCategory.setDescription("test ItemCategory");
		itemCategory.setName("test name");
		
		ItemCategory  itemCategory1 = new ItemCategory();
		itemCategory1.setReference("test reference");
		itemCategory1.setDescription("test ItemCategory");
		itemCategory1.setName("test name 1");
		
		assertFalse(itemCategory.equals(itemCategory1));
		
	}
	










}
