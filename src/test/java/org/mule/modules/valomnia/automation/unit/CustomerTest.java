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
			customer.setId(3);
			customer.setReference("test reference");
			customer.setEmail("email@test.com");
			customer.setName("customer test");
			customer.setAddress(" test adress");
			
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
			customer.setId(3);
			customer.setReference("test reference");
			customer.setEmail("email1@test.com");
			customer.setName("customer test");
			customer.setAddress(" test adress 1");
			
			assertFalse(customer.equals(customer1));
			
		}
		
		
		
	}