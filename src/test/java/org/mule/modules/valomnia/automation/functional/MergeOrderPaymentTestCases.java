/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;

import org.mule.modules.valomnia.entities.OrderPayment;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeOrderPaymentTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeOrderPaymentTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        OrderPayment obj = new OrderPayment();

        boolean exist = false;

        List<OrderPayment> list = null;
        try {
            list = getConnector().findOrdersPayment();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (OrderPayment orderPayment : list)
        {
            if (orderPayment.getPaymentReference()!=null)
                    if (orderPayment.getPaymentReference().equals("ref test OrderPayment"))
                    
                    
                exist = true;
        }
        obj.setPaymentReference("ref test OrderPayment");
        obj.setOrderReference("ref test Order");
       
        
        obj.setPaymentDate("12/02/2017 13:40:12");
        obj.setIsLast("false");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeOrderPayment(obj), expected1);
        else
            assertEquals(getConnector().mergeOrderPayment(obj), expected2);
    }

    @Test
    public void verifyOrderPaymentSaved() {
    	
    	List<OrderPayment> list = null;
    	boolean   exist=false;
        
            list = getConnector().findOrdersPayment();
        
        for (OrderPayment orderPayment:list)
        { if ( orderPayment.getOrderReference().equals("ref test Order")&&  
        		orderPayment.getPaymentReference().equals("ref test OrderPayment"))
            exist=true;
        }
    	assertTrue(exist);
    }
}