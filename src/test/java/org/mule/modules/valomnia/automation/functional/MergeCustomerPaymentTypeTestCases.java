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
import org.mule.modules.valomnia.entities.CustomerPaymentType;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeCustomerPaymentTypeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerPaymentTypeTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        CustomerPaymentType obj = new CustomerPaymentType();

        boolean exist = false;

        List<CustomerPaymentType> list = null;
        try {
            list = getConnector().findCustomersPaymentType();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (CustomerPaymentType customerPaymentType : list)
        {
            if ((customerPaymentType.getReference()
                    .equals("ref test CustomerPaymentType"))
            	&&(customerPaymentType.getName().equals("test CustomerPaymentType")))
                exist = true;
        }
        obj.setName("test CustomerPaymentType");
        
        obj.setReference("ref test CustomerPaymentType");
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerPaymentType(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerPaymentType(obj), expected1);
    }

    @Test
	public void missingReferenceTest() {
		java.lang.String expected = "Reference missing";

		 CustomerPaymentType obj = new CustomerPaymentType();
		
		 obj.setName("test CustomerPaymentType");
	        
	        
		assertTrue(getConnector().mergeCustomerPaymentType(obj).contains(expected));

	}
    @Test
   	public void missingNameTest() {
   		java.lang.String expected = "Name required";

   		 CustomerPaymentType obj = new CustomerPaymentType();
   		
   		 obj.setReference("ref test CustomerPaymentType");
   	        
   	        
   		assertTrue(getConnector().mergeCustomerPaymentType(obj).contains(expected));

   	}
    @Test
    public void verifyCustomerPaymentTypeSaved() {
    	
    	List<CustomerPaymentType> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersPaymentType();
        
        for (CustomerPaymentType customerPaymentType:list)
        { if ( customerPaymentType.getReference().equals("ref test CustomerPaymentType")&&  
        		customerPaymentType.getName().equals("test CustomerPaymentType"))
            exist=true;
        }
    	assertTrue(exist);
    }

}