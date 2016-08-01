/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.mule.modules.valomnia.entities.Employee;

public class EmployeeTest {

	@Test
	public void testCEmployeesAreEqual() {
		
		Employee  employee = new Employee();
		employee.setId("3");
		employee.setReference("test reference");
		employee.setFirstName("test first Name");
		employee.setLastName("test Last Name");
		employee.setMobile("987343");
		
		Employee  employee1 = new Employee();
		employee1.setId("3");
		employee1.setReference("test reference");
		employee1.setFirstName("test first Name");
		employee1.setLastName("test Last Name");
		employee1.setMobile("987343");
		
		assertEquals(employee,employee1);
		
	}
	
	@Test
	public void testemployeesAreNotEqual() {
		Employee  employee = new Employee();
		employee.setId("3");
		employee.setReference("test reference");
		
		employee.setFirstName("test first Name");
		employee.setLastName("test Last Name");
		employee.setMobile("987343");
		
		
		Employee  employee1 = new Employee();
		employee1.setId("8");
		employee1.setReference("test reference");
		
		employee1.setFirstName("test first Name");
		employee1.setLastName("test Last Name");
		employee1.setMobile("77777773");
		
		assertFalse(employee.equals(employee1));
		
	}


}
