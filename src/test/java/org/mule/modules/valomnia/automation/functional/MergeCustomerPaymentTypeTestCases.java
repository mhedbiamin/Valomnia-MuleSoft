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
import org.mule.modules.valomnia.entities.CustomerPaymentType;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

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
        Gson gson = new Gson();
        String js = gson.toJson(list);
       
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<CustomerPaymentType>>() {}.getType();
        ArrayList<CustomerPaymentType> list1 = new Gson().fromJson(js, listType);

        for (CustomerPaymentType customerPaymentType : list1)
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


}