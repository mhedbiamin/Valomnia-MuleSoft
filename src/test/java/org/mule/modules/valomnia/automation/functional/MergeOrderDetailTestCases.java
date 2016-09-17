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
import org.mule.modules.valomnia.entities.OrderDetail;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeOrderDetailTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeOrderDetailTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        OrderDetail obj = new OrderDetail();

        boolean exist = false;

        List<OrderDetail> list = null;
        try {
            list = getConnector().findOrdersDetail();
        } catch (Exception e) {

            e.printStackTrace();
       
        }
        for (OrderDetail orderDetail : list)
            
            
        {
            if (orderDetail.getOrderReference().equals("ref test Order")&
                    orderDetail.getItemReference().equals("ref test Item")&
                    orderDetail.getUnitReference().equals("ref test Unit"))
                    
                exist = true;
        }
        obj.setOrderReference("ref test Order");
        obj.setItemReference("ref test Item");
        obj.setUnitReference("ref test Unit");
        obj.setFinalPrice("90");
        obj.setUnitPrice("4");
        obj.setQuantity("7");
        obj.setTax("2");
     
       

        

        if (exist)
            assertEquals(getConnector().mergeOrderDetail(obj), expected1);
        else
            assertEquals(getConnector().mergeOrderDetail(obj), expected2);
    }
    @Test
    public void verifyOrderDetailSaved() {
    	
    	List<OrderDetail> list = null;
    	boolean   exist=false;
        
            list = getConnector().findOrdersDetail();
        
        for (OrderDetail  orderDetail:list)
        { if (( orderDetail.getOrderReference().equals("ref test Order"))&&(orderDetail.getItemReference().equals("ref test Item"))
        		&&(orderDetail.getUnitReference().equals("ref test Unit"))&&(orderDetail.getFinalPrice().equals("90")))
           
        	exist=true;
        }
    	assertTrue(exist);
    }
    
    
    @Test
    public void misssingOrderReference() {
        java.lang.String expected = "orderReference missing: Failed to save the OrderDetail";
        
        OrderDetail obj = new OrderDetail();
        obj.setItemReference("ref test Item");
        obj.setUnitReference("ref test Unit");
        obj.setFinalPrice("90");
        obj.setUnitPrice("4");
        obj.setQuantity("7");
        obj.setTax("2");
     
       

        

       
            assertTrue(getConnector().mergeOrderDetail(obj).contains(expected));
        
    }

   
}