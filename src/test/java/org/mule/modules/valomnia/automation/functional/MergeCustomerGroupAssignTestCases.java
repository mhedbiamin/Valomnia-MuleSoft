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
import org.mule.modules.valomnia.entities.CustomerGroupAssign;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeCustomerGroupAssignTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerGroupAssignTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
      CustomerGroupAssign obj = new CustomerGroupAssign();

        boolean exist = false;
       

        List<CustomerGroupAssign> list = null;
        
        try {
            list = getConnector().findCustomersGroupAssign();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<CustomerGroupAssign>>() {}.getType();
        ArrayList<CustomerGroupAssign> list1 = new Gson().fromJson(js, listType);

        for (CustomerGroupAssign customgroupAssign : list1)
        {
            if ((customgroupAssign.getCustomerReference().equals("ref test Customer"))&
                    (customgroupAssign.getCustomerGroupReference().equals("ref test CustomerGroup")))
                exist = true;
        }
        
        obj.setCustomerReference("ref test Customer");
        obj.setCustomerGroupReference("ref test CustomerGroup");
        
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerGroupAssign(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerGroupAssign(obj), expected1);
    }



    }

