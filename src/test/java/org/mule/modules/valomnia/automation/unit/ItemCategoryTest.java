package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mule.modules.valomnia.entities.ItemCategory;

public class ItemCategoryTest {



	@Test
	public void testItemCategoryAreEqual() {
		
		ItemCategory  itemCategory = new ItemCategory();
		itemCategory.setId("3");
		itemCategory.setReference("test reference");
		itemCategory.setDescription("test ItemCategory");
		itemCategory.setName("test name");
		
		ItemCategory  itemCategory1 = new ItemCategory();
		itemCategory1.setId("3");
		itemCategory1.setReference("test reference");
		itemCategory1.setDescription("test ItemCategory");
		itemCategory1.setName("test name");
		
		
		assertEquals(itemCategory,itemCategory1);
		
	}
	
	@Test
	public void testItemCategoryAreNotEqual() {
		ItemCategory  itemCategory = new ItemCategory();
		itemCategory.setId("3");
		itemCategory.setReference("test reference");
		itemCategory.setDescription("test ItemCategory");
		itemCategory.setName("test name");
		
		ItemCategory  itemCategory1 = new ItemCategory();
		itemCategory1.setId("6");
		itemCategory1.setReference("test reference");
		itemCategory1.setDescription("test ItemCategory");
		itemCategory1.setName("test name 1");
		
		assertFalse(itemCategory.equals(itemCategory1));
		
	}
	










}
