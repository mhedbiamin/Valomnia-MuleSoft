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
