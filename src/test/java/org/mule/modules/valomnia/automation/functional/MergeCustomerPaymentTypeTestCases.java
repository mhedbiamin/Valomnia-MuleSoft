/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
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
            if (customerPaymentType.getReference()
                    .equals("ref test CustomerPaymentType"))
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
    public void verifyCustomerPaymentTypeSaved() {
    	
    	List<CustomerPaymentType> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersPaymentType();
        
        for (CustomerPaymentType customerPaymentType:list)
        { if ( customerPaymentType.getReference().equals("ref test CustomerPaymentType")&&  
        		customerPaymentType.getName().equals("ref test CustomerPaymentType"))
            exist=true;
        }
    	assertTrue(exist);
    }

}