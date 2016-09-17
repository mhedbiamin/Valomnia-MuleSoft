/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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
