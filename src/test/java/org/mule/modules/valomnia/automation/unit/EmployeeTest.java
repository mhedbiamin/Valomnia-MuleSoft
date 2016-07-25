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
