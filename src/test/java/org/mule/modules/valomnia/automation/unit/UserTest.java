/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
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
