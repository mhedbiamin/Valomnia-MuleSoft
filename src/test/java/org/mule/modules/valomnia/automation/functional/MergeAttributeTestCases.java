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
import org.mule.modules.valomnia.entities.Attribute;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeAttributeTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeAttributeTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {

		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		Attribute obj = new Attribute();

		boolean exist = false;

		List<Attribute> list = null;

		try {
			list = getConnector().findAttributs();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (Attribute attribute : list) {
			if (attribute.getReference() != null)
				if (attribute.getReference().equals("ref test Attribute"))

					exist = true;
		}
		obj.setReference("ref test Attribute");
		obj.setName("test name  Attribute");
		obj.setType("COLOR");

		if (!exist)
			assertEquals(getConnector().mergeAttribute(obj), expected2);
		else
			assertEquals(getConnector().mergeAttribute(obj), expected1);
	}

	@Test
	public void misssingReference() {
		java.lang.String expected = "Reference missing: Failed to save the Attribute";

		Attribute obj = new Attribute();

		obj.setName("test name  Attribute");
		obj.setType("COLOR");
		assertTrue(getConnector().mergeAttribute(obj).contains(expected));

	}

	@Test
	public void typeAttributeTest() {
		java.lang.String expected = "type can have only these values [ COLOR, STRING, NUMBER ]";

		Attribute obj = new Attribute();
		obj.setReference("ref test Attribute 1");
		obj.setName("test name  Attribute");
		obj.setType("value");
		assertTrue(getConnector().mergeAttribute(obj).contains(expected));

	}

	@Test
	public void missingTypeTest() {
		java.lang.String expected = "type missing";

		Attribute obj = new Attribute();
		obj.setReference("ref test Attribute");
		obj.setName("test name  Attribute");

		assertTrue(getConnector().mergeAttribute(obj).contains(expected));

	}

	@Test
	public void missingNameTest() {
		java.lang.String expected = "Name required";

		Attribute obj = new Attribute();
		obj.setReference("ref test Attribute");

		obj.setType("STRING");
		assertTrue(getConnector().mergeAttribute(obj).contains(expected));

	}

	@Test
	public void verifyAttributeSaved() {

		List<Attribute> list = null;
		boolean exist = false;

		list = getConnector().findAttributs();

		for (Attribute attribute : list) {
			if (attribute.getReference().equals("ref test Attribute"))
				exist = true;
		}
		assertTrue(exist);
	}
}