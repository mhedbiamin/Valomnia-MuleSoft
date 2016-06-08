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
import org.mule.modules.valomnia.entities.CustomerPriceList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeCustomerPriceListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerPriceListTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       CustomerPriceList obj = new  CustomerPriceList();
        boolean exist = false;

        List<CustomerPriceList> list = null;
        
        try {
            list = getConnector().findCustomersPriceList();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<CustomerPriceList>>() {}.getType();
        ArrayList<CustomerPriceList> list1 = new Gson().fromJson(js, listType);

        for (CustomerPriceList customerPriceList : list1)
        {
            if (customerPriceList.getCustomerReference().equals("ref test Customer")&
                    customerPriceList.getPriceListReference().equals("ref test PriceList"))
                
                    
                exist = true;
        }
        
        obj.setCustomerReference("ref test Customer");
        obj.setPriceListReference("ref test PriceList");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeCustomerPriceList(obj), expected1);
        else
            assertEquals(getConnector().mergeCustomerPriceList(obj), expected2);
    }



    }

