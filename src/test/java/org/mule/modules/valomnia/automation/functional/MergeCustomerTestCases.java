/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Customer;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeCustomerTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Customer obj = new Customer();

        boolean exist = false;
       
        List<Customer> list = null;
        
        try {
            list = getConnector().findCustomers();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<Customer>>() {}.getType();
        ArrayList<Customer> list1 = new Gson().fromJson(js, listType);

        for (Customer customer : list1)
        {
            if (customer.getReference().equals("ref test Customer"))
                    
                exist = true;
        }
        
        obj.setReference("ref test Customer");
        obj.setName("test  name");
        obj.setCountry("TN");
        obj.setCity("Sousse");
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomer(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomer(obj), expected1);
    }



    }


