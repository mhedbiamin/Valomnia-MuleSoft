package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.User;

public class UserTest {

	@Test
	public void testAuthorityAreEqual() {

		User user = new User();

		user.setEmail("test@test.com");
		user.setOrganization("test Organization");
		user.setEmployeeReference("test employee reference");

		User user1 = new User();

		user1.setEmail("test@test.com");
		user1.setOrganization("test Organization");
		user1.setEmployeeReference("test employee reference");

		assertEquals(user, user1);

	}

	@Test
	public void testAuthorityAreNotEqual() {
		User user = new User();

		user.setEmail("test@test.com");
		user.setOrganization("test Organization");
		user.setEmployeeReference("test employee reference");

		User user1 = new User();

		user1.setEmail("test@test.com");
		user1.setOrganization("test Organization");
		user1.setEmployeeReference("test employee reference1");

		assertFalse(user.equals(user1));

	}

}
