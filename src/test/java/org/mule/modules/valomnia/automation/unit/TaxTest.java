/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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
