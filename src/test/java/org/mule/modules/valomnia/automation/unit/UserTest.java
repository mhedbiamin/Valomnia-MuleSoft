package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.valomnia.entities.User;

public class UserTest {

	@Test
	public void testAuthorityGetters() {

		User user = new User();

		user.setEmail("test@test.com");

		user.setEmployeeReference("test employee reference");
		user.setEnabled("true");

		assertEquals(user.getEmail(), "test@test.com");
		assertEquals(user.getEmployeeReference(), "test employee reference");
		assertEquals(user.getEnabled(), "true");

	}

}
