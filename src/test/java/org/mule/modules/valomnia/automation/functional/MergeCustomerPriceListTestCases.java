/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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
