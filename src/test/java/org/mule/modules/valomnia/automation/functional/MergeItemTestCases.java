/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Item;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeItemTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeItemTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		Item obj = new Item();

		boolean exist = false;

		List<Item> list = null;
		try {
			list = getConnector().findItems();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (Item item : list) {
			if (item.getReference().equals("ref test Item"))
				exist = true;
		}
		obj.setName("test Item");
		obj.setReference("ref test Item");
		obj.setCategoryReference("ref test ItemCategory");

		obj.setDescription("TEST DESCRIPTION");

		if (!exist)
			assertEquals(getConnector().mergeItem(obj), expected2);
		else
			assertEquals(getConnector().mergeItem(obj), expected1);
		/*change the   Item Description */
		obj.setDescription("update description");
		assertEquals(getConnector().mergeItem(obj), expected1);
		/* change the Item Name */
		obj.setName("test Item Updated");
		assertEquals(getConnector().mergeItem(obj), expected1);
		try {
			list = getConnector().findItems();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (Item item : list) {
			if (item.getReference().equals("ref test Item"))
				obj=item;
		}
		assertEquals(obj.getDescription(), "update description");
		assertEquals(obj.getName(), "test Item Updated");
	}

	@Test
	public void itemReferenceMissingTest() {
		java.lang.String expected = "Reference missing";

		Item obj = new Item();
		obj.setName("test Item");

		obj.setCategoryReference("ref test ItemCategory");

		obj.setDescription("TEST DESCRIPTION");

		String apiResponse = getConnector().mergeItem(obj);
		assertTrue(apiResponse.contains(expected));
	}

	@Test
	public void verifyItemSaved() {

		List<Item> list = null;
		boolean exist = false;

		list = getConnector().findItems();

		for (Item item : list) {
			if (item.getReference().equals("ref test Item"))
				exist = true;
		}
		assertTrue(exist);
	}

	@Test
	public void missingItemNameTest() {

		java.lang.String expected = "Name required";

		Item obj = new Item();
		obj.setReference("ref test Item");

		obj.setCategoryReference("ref test ItemCategory");

		obj.setDescription("TEST DESCRIPTION");

		String apiResponse = getConnector().mergeItem(obj);
		assertTrue(apiResponse.contains(expected));
	}

	/*@Test
	public void updateItemTest() {

		java.lang.String expected = "OK";

		Item obj = new Item();
		obj.setName("test Item");
		obj.setReference("ref test Item");
		obj.setCategoryReference("ref test ItemCategory");

		

		

		String apiResponse = getConnector().mergeItem(obj);
		assertTrue(apiResponse.contains(expected));
	}
	*/
}
