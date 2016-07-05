/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.CustomerEmployee;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeCustomerEmployeeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerEmployeeTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       CustomerEmployee obj = new CustomerEmployee();

        boolean exist = false;

        List<CustomerEmployee> list = null;
        try {
            list = getConnector().findCustomersEmployee();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (CustomerEmployee customerEmployee : list)
        {
            if (customerEmployee.getEmployeeReference().equals("ref test Employee")&
                    customerEmployee.getCustomerReference().equals("ref test Customer"))
                   
                exist = true;
        }
        obj.setCustomerReference("ref test Customer");
        obj.setEmployeeReference("ref test Employee");
        

        if (!exist)
            assertEquals(getConnector().mergeCustomerEmployee(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerEmployee(obj), expected1);
    }

    
    @Test
    public void verifyCustomerEmployeeSaved() {
    	
    	List<CustomerEmployee> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersEmployee();
        
        for (CustomerEmployee customerEmployee:list)
        { if ( customerEmployee.getCustomerReference().equals("ref test Customer")&&  customerEmployee.getEmployeeReference().equals("ref test Employee")) 
        	
            exist=true;
        }
    	assertTrue(exist);
    }
}
