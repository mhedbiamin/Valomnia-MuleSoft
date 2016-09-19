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
import org.mule.modules.valomnia.entities.CustomerPriceList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeCustomerPriceListTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeCustomerPriceListTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		CustomerPriceList obj = new CustomerPriceList();
		boolean exist = false;

		List<CustomerPriceList> list = null;

		try {
			list = getConnector().findCustomersPriceList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (CustomerPriceList customerPriceList : list) {
			if (customerPriceList.getCustomerReference().equals("ref test Customer")
					& customerPriceList.getPriceListReference().equals("ref test PriceList"))

				exist = true;
		}

		obj.setCustomerReference("ref test Customer");
		obj.setPriceListReference("ref test PriceList");

		if (exist)
			assertEquals(getConnector().mergeCustomerPriceList(obj), expected1);
		else
			assertEquals(getConnector().mergeCustomerPriceList(obj), expected2);
	}

	@Test
	public void missingPriceListReferenceTest() {
		java.lang.String expected = "priceListReference required";

		CustomerPriceList obj = new CustomerPriceList();

		obj.setCustomerReference("ref test Customer");

		assertTrue(getConnector().mergeCustomerPriceList(obj).contains(expected));

	}

	@Test
	public void missingCustomerReferenceTest() {
		java.lang.String expected = "customerReference required";

		CustomerPriceList obj = new CustomerPriceList();

		obj.setPriceListReference("ref test PriceList");

		assertTrue(getConnector().mergeCustomerPriceList(obj).contains(expected));

	}

	@Test
	public void verifyCustomerPriceListSaved() {

		List<CustomerPriceList> list = null;
		boolean exist = false;

		list = getConnector().findCustomersPriceList();

		for (CustomerPriceList customerPriceList : list) {
			if (customerPriceList.getCustomerReference().equals("ref test Customer")
					&& customerPriceList.getPriceListReference().equals("ref test PriceList"))
				exist = true;
		}
		assertTrue(exist);
	}

}
