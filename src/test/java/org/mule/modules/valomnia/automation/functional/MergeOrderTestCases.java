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
import org.mule.modules.valomnia.entities.Order;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeOrderTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeOrderTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		Order obj = new Order();

		boolean exist = false;

		List<Order> list = null;
		try {
			list = getConnector().findOrders();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (Order order : list) {
			if (order.getReference().equals("ref test Order"))

				exist = true;
		}
		obj.setReference("ref test Order");

		obj.setTotalProducts("10");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalHT("100");

		obj.setStatus("PAID");
		

		if (exist)
			assertEquals(getConnector().mergeOrder(obj), expected1);
		else
			assertEquals(getConnector().mergeOrder(obj), expected2);
	}

	@Test
	public void missingReferenceTest() {
		java.lang.String expected = "Reference missing";

		Order obj = new Order();
		obj.setTotalProducts("10");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalHT("100");

		obj.setStatus("PAID");

		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}

	@Test
	public void missingTotalProductsTest() {
		java.lang.String expected = "totalProducts required";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalHT("100");

		obj.setStatus("PAID");

		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}

	@Test
	public void missingTotalHTTest() {
		java.lang.String expected = "totalHT required";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalProducts("10");

		obj.setStatus("PAID");

		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}

	@Test
	public void customerNotFoundTest() {
		java.lang.String expected = "Customer not found";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer1");
		obj.setUserReference("ref test Employee");
		obj.setTotalProducts("10");

		obj.setStatus("PAID");
		obj.setTotalHT("100");
		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}
	
	@Test
	public void missingStatusTest() {
		java.lang.String expected = "status required";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalProducts("10");
		obj.setTotalHT("100");
		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}
	
	@Test
	public void notPositiveTotalProductsTest() {
		java.lang.String expected = "totalProducts value must be positive";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalProducts("-10");
		obj.setTotalHT("100");
		obj.setStatus("PAID");
		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}
	
	
	@Test
	public void notDoubleTotalHTTest() {
		java.lang.String expected = "totalHT must be a Double";

		Order obj = new Order();
		obj.setReference("ref test Order");
		obj.setCustomerReference("ref test Customer");
		obj.setUserReference("ref test Employee");
		obj.setTotalProducts("10");
		obj.setTotalHT("A");
		obj.setStatus("PAID");
		assertTrue(getConnector().mergeOrder(obj).contains(expected));

	}
	@Test
	public void verifyOrderSaved() {

		List<Order> list = null;
		boolean exist = false;

		list = getConnector().findOrders();

		for (Order order : list) {
			if (order.getReference().equals("ref test Order"))
				exist = true;
		}
		assertTrue(exist);
	}

}