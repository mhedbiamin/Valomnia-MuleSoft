/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.WareHouseStock;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeWareHouseStockTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeWareHouseStockTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		WareHouseStock obj = new WareHouseStock();

		boolean exist = false;

		List<WareHouseStock> list = null;

		try {
			list = getConnector().findWareHouseStocks();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (WareHouseStock wareHouseStock : list) {
			if (wareHouseStock.getWarehouseReference().equals("ref test WareHouse")
					& wareHouseStock.getItemReference().equals("ref test Item")
					& wareHouseStock.getUnitReference().equals("ref test Unit"))

				exist = true;
		}

		obj.setWarehouseReference("ref test WareHouse");
		obj.setItemReference("ref test Item");
		obj.setUnitReference("ref test Unit");
		obj.setQuantity("10");

		if (exist)
			assertEquals(getConnector().mergeWareHouseStock(obj), expected1);
		else
			assertEquals(getConnector().mergeWareHouseStock(obj), expected2);
	}

	@Test
	public void verifyWarehouseStockSaved() {

		List<WareHouseStock> list = null;
		boolean exist = false;

		list = getConnector().findWareHouseStocks();

		for (WareHouseStock wareHouseStock : list) {
			if (wareHouseStock.getWarehouseReference().equals("ref test WareHouse")
					&& wareHouseStock.getItemReference().equals("ref test Item")
					&& wareHouseStock.getUnitReference().equals("ref test Unit"))
				exist = true;
		}
		assertTrue(exist);

	}
}