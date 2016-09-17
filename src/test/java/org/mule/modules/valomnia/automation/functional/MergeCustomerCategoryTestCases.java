/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.CustomerCategory;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeCustomerCategoryTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerCategoryTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String  expected2 = "Success created";
        CustomerCategory obj = new CustomerCategory();

        boolean exist = false;

        List<CustomerCategory> list = null;
        try {
            list = getConnector().findCustomersCategory();
        } catch (Exception e) {

            e.printStackTrace();
        }
        

        for (CustomerCategory customerCategory : list)
        {
            if (customerCategory.getReference()
                    .equals("ref test CustomerCategory"))
                exist = true;
        }
        obj.setReference("ref test CustomerCategory");

        obj.setName("test name");

        if (!exist)
            assertEquals(getConnector().mergeCustomerCategory(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerCategory(obj), expected1);
    }
    
    
    @Test
    public void missingReferenceTest() {
        java.lang.String expected = "Reference missing";
       
        CustomerCategory obj = new CustomerCategory();

       obj.setDescription("Test customer category");

        obj.setName("test name");

       
       
            assertTrue(getConnector().mergeCustomerCategory(obj).contains(expected));
    }
    
    
    @Test
    public void verifyCustomerCategorySaved() {
    	
    	List<CustomerCategory> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersCategory();
        
        for (CustomerCategory customerCategory:list)
        { if ( customerCategory.getReference().equals("ref test CustomerCategory"))
        	
            exist=true;
        }
    	assertTrue(exist);
    }


}