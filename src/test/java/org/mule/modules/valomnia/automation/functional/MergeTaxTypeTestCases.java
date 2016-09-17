/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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