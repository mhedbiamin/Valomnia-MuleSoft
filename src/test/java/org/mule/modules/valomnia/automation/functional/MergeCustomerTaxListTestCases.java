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
