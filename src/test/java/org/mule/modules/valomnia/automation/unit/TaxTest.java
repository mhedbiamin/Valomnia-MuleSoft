/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.mule.modules.valomnia.entities.Tax;

public class TaxTest {
	@Test
	public void testTaxGetters() {

		Tax tax = new Tax();

		tax.setItemReference("Reference test");

		tax.setTaxListReference("taxList Reference");
		tax.setTaxValue("tax Value");

		assertEquals(tax.getItemReference(), "Reference test");
		assertEquals(tax.getTaxListReference(), "taxList Reference");
		assertEquals(tax.getTaxValue(), "tax Value");

	}

}
