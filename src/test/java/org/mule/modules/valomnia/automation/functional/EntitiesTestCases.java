/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Employee;
import org.mule.modules.valomnia.entities.EmployeeGroup;
import org.mule.modules.valomnia.entities.User;
import org.mule.modules.valomnia.entities.UserAuthority;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class EntitiesTestCases   extends AbstractTestCase<ValomniaConnector> {
	 public EntitiesTestCases() {
	        super(ValomniaConnector.class);
	    }
	
	 @Test
	 public void verify() throws Exception {
		 Employee  employee=new Employee();
		 employee.setFirstName("test first name");
		 employee.setLastName("test LasrtName");
		 employee.setMobile("000986754");
		 employee.setReference("test Employee");
		 
		 User user= new User();
		 user.setEmail("test@test.com");
		 Employee employee1=null;
		 for (Employee  emp :getConnector().findEmployees())
		 {if  (emp.getReference().equals("test Employee"))
		 employee1=emp;
		 }
		 if (employee1==null)
		 { assertNotNull(getConnector().mergeEmployee(employee));}
		user.setEmployeeReference(employee.getReference());
		 
		 assertNotNull( getConnector().mergeUser(user));
		 UserAuthority userAuthority=new UserAuthority();
		 userAuthority.setAuthorityName("test Authority name");
		 userAuthority.setUserEmail("test@test.com");
		 assertNotNull( getConnector().mergeUserAuthority(userAuthority));
		 
		 EmployeeGroup  employeeGroup=new EmployeeGroup();
		 employeeGroup.setName("Test EmployeeGroup");
		 employeeGroup.setReference("Test EmployeeGroup Reference");
		 assertNotNull( getConnector().mergeEmployeeGroup(employeeGroup));
		 
		 employee.setEmployeeGroupReference("Test EmployeeGroup Reference");
		 
		 assertTrue(getConnector().mergeEmployee(employee).equals("Success Updated"));
		 
		 
		 
		
	 }
}
