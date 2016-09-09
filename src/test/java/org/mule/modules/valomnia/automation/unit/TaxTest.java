package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Tax;

public class TaxTest {
	@Test
	public void testTaxAreEqual() {

		Tax tax = new Tax();

		tax.setItemReference("Reference test");
		tax.setOrganization("test Organization");
		tax.setTaxListReference("taxList Reference");

		Tax tax1 = new Tax();

		tax1.setItemReference("Reference test");
		tax1.setOrganization("test Organization");
		tax1.setTaxListReference("taxList Reference");

		assertEquals(tax, tax1);

	}

	@Test
	public void testTaxAreNotEqual() {
		Tax tax = new Tax();

		tax.setItemReference("Reference test 1");
		tax.setOrganization("test Organization");
		tax.setTaxListReference("taxList Reference1");

		Tax tax1 = new Tax();

		tax1.setItemReference("Reference test");
		tax1.setOrganization("test Organization");
		tax1.setTaxListReference("taxList Reference");

		assertFalse(tax.equals(tax1));

	}
}
