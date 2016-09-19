/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Order;

import java.lang.reflect.Field;

public class OrderTest {

	@Test
	public void testSetterReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		// given
		Order order = new Order();

		// when
		order.setReference("test reference");

		// then
		final Field field = order.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		assertEquals(field.get(order), "test reference");
	}

	@Test
	public void testSetterStatus_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		// given
		Order order = new Order();

		// when
		order.setStatus("PAYED");

		// then
		Field field = order.getClass().getDeclaredField("status");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(order), "PAYED");
	}

	@Test
	public void testGetterReferssence_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Order order = new Order();

		Field field = order.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		field.set(order, "test reference");

		// when
		final String result = order.getReference();

		// then
		assertEquals("field wasn't retrieved properly", result, "test reference");
	}

	@Test
	public void testOrderGetters() {

		Order order = new Order();
		order.setReference("test reference");
		order.setStatus("Payed");
		order.setDelivaryCity("test City");
		order.setDelivaryAddress("delivary Address");
		order.setCustomerPaymentTypeReference("customerPaymentTypeReference");
		order.setDeliveryDate("12/3/2000");
		order.setDeliveryStatus("PENDING");
		order.setOperationType("order");
		order.setCustomerReference("customerReference");
		order.setDelivaryCountry("delivaryCountry");

		assertEquals(order.getStatus(), "Payed");
		assertEquals(order.getDelivaryCity(), "test City");
		assertEquals(order.getDelivaryAddress(), "delivary Address");
		assertEquals(order.getCustomerPaymentTypeReference(), "customerPaymentTypeReference");
		assertEquals(order.getDeliveryDate(), "12/3/2000");
		assertEquals(order.getDeliveryStatus(), "PENDING");
		assertEquals(order.getOperationType(), "order");
		assertEquals(order.getCustomerReference(), "customerReference");
		assertEquals(order.getDelivaryCountry(), "delivaryCountry");

	}

}
