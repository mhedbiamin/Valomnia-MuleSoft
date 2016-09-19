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
import org.mule.modules.valomnia.entities.AttributeValue;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeAttributeValueTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeAttributeValueTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		AttributeValue obj = new AttributeValue();

		boolean exist = false;

		List<AttributeValue> list = null;

		try {
			list = getConnector().findAttributesValue();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (AttributeValue attributeValue : list) {
			if (attributeValue.getAttributeReference() != null)
				if (attributeValue.getAttributeReference().equals("ref test Attribute")
						& attributeValue.getValue().equals("S"))

					exist = true;
		}

		obj.setAttributeReference("ref test Attribute");
		obj.setValue("S");

		if (!exist)
			assertEquals(getConnector().mergeAttributeValue(obj), expected2);
		else
			assertEquals(getConnector().mergeAttributeValue(obj), expected1);
	}

	@Test
	public void missingAttributeReferenceTest() {
		java.lang.String expected = "attributeReference missing";

		AttributeValue obj = new AttributeValue();

		obj.setValue("S");

		assertTrue(getConnector().mergeAttributeValue(obj).contains(expected));

	}

	@Test
	public void missingValueTest() {
		java.lang.String expected = "value missing";

		AttributeValue obj = new AttributeValue();

		obj.setAttributeReference("ref test Attribute");

		assertTrue(getConnector().mergeAttributeValue(obj).contains(expected));

	}

	@Test
	public void attributeNotFoundTest() {
		java.lang.String expected = "Attribute not found";

		AttributeValue obj = new AttributeValue();

		obj.setAttributeReference("ref test Attribute12");
		obj.setValue("S");
		assertTrue(getConnector().mergeAttributeValue(obj).contains(expected));

	}

	@Test
	public void verifyAttributeValueSaved() {

		List<AttributeValue> list = null;
		boolean exist = false;

		list = getConnector().findAttributesValue();

		for (AttributeValue attributeValue : list) {
			if (attributeValue.getAttributeReference().equals("ref test Attribute"))
				exist = true;
		}
		assertTrue(exist);
	}

}