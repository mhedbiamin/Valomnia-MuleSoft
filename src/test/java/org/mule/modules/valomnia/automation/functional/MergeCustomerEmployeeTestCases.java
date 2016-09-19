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
import org.mule.modules.valomnia.entities.CustomerEmployee;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeCustomerEmployeeTestCases extends
		AbstractTestCase<ValomniaConnector> {

	public MergeCustomerEmployeeTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		CustomerEmployee obj = new CustomerEmployee();

		boolean exist = false;

		List<CustomerEmployee> list = null;
		try {
			list = getConnector().findCustomersEmployee();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (CustomerEmployee customerEmployee : list) {
			if (customerEmployee.getEmployeeReference().equals(
					"ref test Employee")
					& customerEmployee.getCustomerReference().equals(
							"ref test Customer"))

				exist = true;
		}
		obj.setCustomerReference("ref test Customer");
		obj.setEmployeeReference("ref test Employee");

		if (!exist)
			assertEquals(getConnector().mergeCustomerEmployee(obj), expected2);
		else
			assertEquals(getConnector().mergeCustomerEmployee(obj), expected1);
	}

	@Test
	public void missingCustomerReference() {

		java.lang.String expected = "customerReference required";
		CustomerEmployee obj = new CustomerEmployee();

		obj.setEmployeeReference("ref test Employee");

		assertTrue(getConnector().mergeCustomerEmployee(obj).contains(expected));

	}

	@Test
	public void verifyCustomerEmployeeSaved() {

		List<CustomerEmployee> list = null;
		boolean exist = false;

		list = getConnector().findCustomersEmployee();

		for (CustomerEmployee customerEmployee : list) {
			if (customerEmployee.getCustomerReference().equals(
					"ref test Customer")
					&& customerEmployee.getEmployeeReference().equals(
							"ref test Employee"))

				exist = true;
		}
		assertTrue(exist);
	}
}
