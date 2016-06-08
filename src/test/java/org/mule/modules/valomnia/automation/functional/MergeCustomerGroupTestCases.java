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
import org.mule.modules.valomnia.entities.CustomerGroup;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeCustomerGroupTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerGroupTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       CustomerGroup obj = new CustomerGroup();

        boolean exist = false;

        List<CustomerGroup> list = null;
        
        try {
            list = getConnector().findCustomersGroup();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<CustomerGroup>>() {}.getType();
        ArrayList<CustomerGroup> list1 = new Gson().fromJson(js, listType);

        for (CustomerGroup customerGroup: list1)
        {
            if (customerGroup.getReference().equals("ref test CustomerGroup"))
                    
                exist = true;
        }
        
        obj.setReference("ref test CustomerGroup");
        obj.setName("test name  CustomerGroup");
        

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerGroup(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerGroup(obj), expected1);
    }



    }


