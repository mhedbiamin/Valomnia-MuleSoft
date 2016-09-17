/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.CustomerTaxList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeCustomerTaxListTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeCustomerTaxListTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		CustomerTaxList obj = new CustomerTaxList();

		boolean exist = false;

		List<CustomerTaxList> list = null;
		try {
			list = getConnector().findCustomersTaxList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (CustomerTaxList customerTaxList : list) {
			if (customerTaxList.getCustomerReference() != null)
				if (customerTaxList.getCustomerReference().equals("ref test Customer")
						& customerTaxList.getTaxListReference().equals("test TaxList Reference"))
					exist = true;
		}
		obj.setCustomerReference("ref test Customer");

		obj.setTaxListReference("test TaxList Reference");

		if (!exist)
			assertEquals(getConnector().mergeCustomerTaxList(obj), expected2);
		else
			assertEquals(getConnector().mergeCustomerTaxList(obj), expected1);
	}

	@Test
	public void missingTaxListReferenceTest() {
		java.lang.String expected = "taxListReference required";

		CustomerTaxList obj = new CustomerTaxList();

		obj.setCustomerReference("ref test CustomerPaymentType");

		assertTrue(getConnector().mergeCustomerTaxList(obj).contains(expected));

	}

	@Test
	public void verifyCustomerTaxListSaved() {

		List<CustomerTaxList> list = null;
		boolean exist = false;

		list = getConnector().findCustomersTaxList();

		for (CustomerTaxList customerTaxList : list) {
			if ((customerTaxList.getCustomerReference() != null)
					&& (customerTaxList.getCustomerReference().equals("ref test Customer"))
					&& (customerTaxList.getTaxListReference().equals("test TaxList Reference")))
				exist = true;
		}
		assertTrue(exist);
	}

}
