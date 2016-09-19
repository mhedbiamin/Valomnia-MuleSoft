/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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