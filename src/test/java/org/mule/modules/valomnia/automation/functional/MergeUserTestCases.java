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
import org.mule.modules.valomnia.entities.User;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeUserTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeUserTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		User obj = new User();

		boolean exist = false;

		List<User> list = null;

		try {
			list = getConnector().findUsers();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (User user : list) {
			if (user.getEmail().equals("Test@valomnia.com"))

				exist = true;
		}

		obj.setEmail("Test@valomnia.com");
		obj.setEmployeeReference("ref test Employee");
		obj.setEnabled("FALSE");

		if (exist)
			assertEquals(getConnector().mergeUser(obj), expected1);
		else
			assertEquals(getConnector().mergeUser(obj), expected2);
	}

	

	@Test
	public void verifyUserSaved() {

		List<User> list = null;
		boolean exist = false;
		User obj = null;
		list = getConnector().findUsers();

		for (User user : list) {
			if (user.getEmployeeReference().equals("ref test Employee"))
			{    obj=user;
				exist = true;
			}
		}
		assertTrue(exist);
		/* update the  mail of User */
		obj.setEnabled("TRUE");
		assertEquals(getConnector().mergeUser(obj), "Success Updated");
		list = getConnector().findUsers();
		
		for (User user : list) {
			if (user.getEmployeeReference().equals("ref test Employee"))
			{    obj=user;
				
			}
		}
		
		
		
		assertEquals(obj.getEnabled(), "true");
	}

}