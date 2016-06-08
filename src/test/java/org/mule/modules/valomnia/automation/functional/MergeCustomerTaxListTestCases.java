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
import org.mule.modules.valomnia.entities.CustomerTaxList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeCustomerTaxListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerTaxListTestCases() {
        super(ValomniaConnector.class);
    }
    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        CustomerTaxList obj = new CustomerTaxList();

        boolean exist = false;

        List<CustomerTaxList> list = null;
        try {
            list = getConnector().findCustomersTaxList();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
       
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<CustomerTaxList>>() {}.getType();
        ArrayList<CustomerTaxList> list1 = new Gson().fromJson(js, listType);

        for (CustomerTaxList customerTaxList : list1)
        {      if (customerTaxList.getCustomerReference()!=null)
            if ( customerTaxList.getCustomerReference()
                    .equals("ref test Customer")& customerTaxList.getTaxListName().equals("test TaxList"))
                exist = true;
        }
        obj.setCustomerReference("ref test Customer");
        
        obj.setTaxListName("test TaxList");
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerTaxList(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerTaxList(obj), expected1);
    }


}
