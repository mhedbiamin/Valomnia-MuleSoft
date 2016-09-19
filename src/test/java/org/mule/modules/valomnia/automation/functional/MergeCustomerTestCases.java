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
