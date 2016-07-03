/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Order;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeOrderTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeOrderTestCases() {
        super(ValomniaConnector.class);
    }
    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        Order obj = new Order();

        boolean exist = false;

        List<Order> list = null;
        try {
            list = getConnector().findOrders();
        } catch (Exception e) {

            e.printStackTrace();
        }
      

        for (Order order : list)
        {
            if (order.getReference()
                    .equals("ref test Order"))
                    
                exist = true;
        }
        obj.setReference("ref test Order");
        
        obj.setTotalProducts("10");
        obj.setCustomerReference("ref test Customer");
        obj.setUserReference("ref test Employee");
        obj.setTotalHT("100");
        
       obj.setStatus("PAID");
       

        

        if (exist)
            assertEquals(getConnector().mergeOrder(obj), expected1);
        else
            assertEquals(getConnector().mergeOrder(obj), expected2);
    }

}