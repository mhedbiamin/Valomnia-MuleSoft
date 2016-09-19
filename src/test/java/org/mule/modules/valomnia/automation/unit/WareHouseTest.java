/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */

package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;
import org.mule.modules.valomnia.entities.WareHouse;

public class WareHouseTest {

	@Test
	public void testSetterWareHouseReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		WareHouse wareHouse = new WareHouse();

		wareHouse.setReference("test reference");

		final Field field = wareHouse.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		assertEquals(field.get(wareHouse), "test reference");
	}

	@Test
	public void testSetterWareHouseEmployeeReference_setsProperly()
			throws NoSuchFieldException, IllegalAccessException {
		WareHouse wareHouse = new WareHouse();

		wareHouse.setEmployeeReference("test employee reference");

		final Field field = wareHouse.getClass().getDeclaredField("employeeReference");
		field.setAccessible(true);

		assertEquals("Fields didn't match", field.get(wareHouse), "test employee reference");
	}

	@Test
	public void testGetterReference() throws NoSuchFieldException, IllegalAccessException {

		WareHouse wareHouse = new WareHouse();

		Field field = wareHouse.getClass().getDeclaredField("reference");
		field.setAccessible(true);
		field.set(wareHouse, "test reference");

		final String result = wareHouse.getReference();

		assertEquals("field wasn't retrieved properly", result, "test reference");
	}

	@Test
	public void testWareHouseGetters() {

		WareHouse wareHouse = new WareHouse();
		wareHouse.setReference("test reference");
		wareHouse.setEmployeeReference("employee reference");
		wareHouse.setName("wareHouse name");
		wareHouse.setDescription("description");
		wareHouse.setAddress("address");

		assertEquals(wareHouse.getName(), "wareHouse name");
		assertEquals(wareHouse.getEmployeeReference(), "employee reference");
		assertEquals(wareHouse.getDescription(), "description");
		assertEquals(wareHouse.getAddress(), "address");

	}

}
