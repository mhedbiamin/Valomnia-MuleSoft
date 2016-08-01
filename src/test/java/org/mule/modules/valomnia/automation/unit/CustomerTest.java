/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Customer;

public class CustomerTest {

	

	@Test
		public void testCustomersAreEqual() {
			
			Customer  customer = new Customer();
			customer.setId(3);
			customer.setReference("test reference");
			customer.setEmail("email@test.com");
			customer.setName("customer test");
			customer.setAddress(" test adress");
			
			Customer  customer1 = new Customer();
			customer1.setId(3);
			customer1.setReference("test reference");
			customer1.setEmail("email@test.com");
			customer1.setName("customer test");
			customer1.setAddress(" test adress");
			
			assertEquals(customer,customer1);
			
		}
		
		@Test
		public void testCustomersAreNotEqual() {
			Customer  customer = new Customer();
			customer.setId(3);
			customer.setReference("test reference");
			
			customer.setEmail("email@test.com");
			customer.setName("customer test");
			customer.setAddress(" test adress");
			
			
			Customer  customer1 = new Customer();
			customer1.setId(3);
			customer1.setReference("test reference");
			customer1.setEmail("email1@test.com");
			customer1.setName("customer test");
			customer1.setAddress(" test adress 1");
			
			assertFalse(customer.equals(customer1));
			
		}
		
		
		
	}
