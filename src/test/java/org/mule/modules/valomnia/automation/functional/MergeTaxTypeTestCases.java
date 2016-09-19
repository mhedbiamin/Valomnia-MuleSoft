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
import org.mule.modules.valomnia.entities.TaxType;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeTaxTypeTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeTaxTypeTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		TaxType obj = new TaxType();

		boolean exist = false;

		List<TaxType> list = null;

		try {
			list = getConnector().findTaxTypes();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (TaxType taxType : list) {
			if (taxType.getName().equals("test TaxType"))

				exist = true;
		}

		obj.setName("test TaxType");
		obj.setIsActive("FALSE");

		if (exist)
			assertEquals(getConnector().mergeTaxType(obj), expected1);
		else
			assertEquals(getConnector().mergeTaxType(obj), expected2);

		obj.setIsActive("TRUE");
		assertEquals(getConnector().mergeTaxType(obj), expected1);

	}

}