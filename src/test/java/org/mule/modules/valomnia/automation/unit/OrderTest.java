/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mule.modules.valomnia.entities.Order;

public class OrderTest {

	@Test
	public void testOrederssAreEqual() {
		
		Order order = new Order ();
		order.setId("3");
		order.setReference("test reference");
		order.setStatus("Payed");
		order.setOrganization("test organization");
		
		Order order1 = new Order ();
		order1.setId("3");
		order1.setReference("test reference");
		order1.setStatus("Payed");
		order1.setOrganization("test organization");
		
		
		assertEquals(order,order1);
		
	}
	
	@Test
	public void testOrdersAreNotEqual() {
		Order order = new Order ();
		order.setId("5");
		order.setReference("test reference 1");
		order.setStatus("Payed");
		order.setOrganization("test organization");
		
		Order order1 = new Order ();
		order1.setId("3");
		order1.setReference("test reference");
		order1.setStatus("Payed");
		order1.setOrganization("test organization");
		
		
		
		
		assertFalse(order.equals(order1));
		
	}
	
	
	
}
