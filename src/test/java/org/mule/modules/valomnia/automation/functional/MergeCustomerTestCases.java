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
import org.mule.modules.valomnia.entities.Customer;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeCustomerTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeCustomerTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		Customer obj = new Customer();

		boolean exist = false;

		List<Customer> list = null;

		try {
			list = getConnector().findCustomers();
		} catch (Exception e) {

			e.printStackTrace();
		}
			for (Customer customer : list) {
				if (customer.getReference().equals("ref test Customer"))

					exist = true;
			}

			obj.setReference("ref test Customer");
			obj.setName("test  name");
			obj.setCountry("TN");
			obj.setCity("Sousse");

			if (!exist)
				assertEquals(getConnector().mergeCustomer(obj), expected2);
			else
				assertEquals(getConnector().mergeCustomer(obj), expected1);
		
		/* change the Customer Name */
		obj.setName("test  name Updated");
		assertEquals(getConnector().mergeCustomer(obj), expected1);
		/* change the Customer City */
		obj.setCity("NICE");
		assertEquals(getConnector().mergeCustomer(obj), expected1);
		/* change the Customer Country */
		obj.setCountry("FR");
		assertEquals(getConnector().mergeCustomer(obj), expected1);
		try {
			list = getConnector().findCustomers();
		} catch (Exception e) {

			e.printStackTrace();
		}
			for (Customer customer : list) {
				if (customer.getReference().equals("ref test Customer"))

					obj=customer;
			}
			assertEquals(obj.getName(),"test  name Updated" );
			assertEquals(obj.getCity(),"NICE" );
			assertEquals(obj.getCountry(),"FR" );
			
	}

	@Test
	public void missingReferenceTest() {
		java.lang.String expected = "Reference missing";

		Customer obj = new Customer();

		obj.setName("test  name");
		obj.setCountry("TN");
		obj.setCity("Sousse");

		String apiResponse = getConnector().mergeCustomer(obj);
		assertTrue(apiResponse.contains(expected));

	}

	@Test
	public void missingNameTest() {
		java.lang.String expected = "Name required";

		Customer obj = new Customer();

		obj.setReference("ref test Customer");
		obj.setCountry("TN");
		obj.setCity("Sousse");

		String apiResponse = getConnector().mergeCustomer(obj);
		assertTrue(apiResponse.contains(expected));

	}

	@Test
	public void customerCategoryNotFoundTest() {
		java.lang.String expected = "Category not found";

		Customer obj = new Customer();

		obj.setReference("ref test Customer");
		obj.setName("test  name");
		obj.setCategoryReference("category ");
		obj.setCountry("TN");
		obj.setCity("Sousse");

		String apiResponse = getConnector().mergeCustomer(obj);
		assertTrue(apiResponse.contains(expected));

	}

	@Test
	public void verifyCustomerSaved() {

		List<Customer> list = null;
		boolean exist = false;

		list = getConnector().findCustomers();

		for (Customer customer : list) {
			if (customer.getReference().equals("ref test Customer"))
				exist = true;
		}
		assertTrue(exist);
	}

}
