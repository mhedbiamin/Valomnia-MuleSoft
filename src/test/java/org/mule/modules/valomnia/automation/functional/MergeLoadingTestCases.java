/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Loading;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.gson.Gson;

public class MergeLoadingTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeLoadingTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Loading obj = new Loading();
        boolean exist = false;

        List<Loading> list = null;
        
        try {
            list = getConnector().findLoadings();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<Loading>>() {}.getType();
        ArrayList<Loading> list1 = new Gson().fromJson(js, listType);

        for (Loading loading : list1)
        {
            if (loading.getReference().equals("ref test Loading"))
                    
                exist = true;
        }
        
        obj.setReference("ref test Loading");
        obj.setWarehouseReference("ref test WareHouse");
        obj.setType("1");
        obj.setWarehouseType("1");
       

        

        if (exist)
            assertEquals(getConnector().mergeLoading(obj), expected1);
        else
            assertEquals(getConnector().mergeLoading(obj), expected2);
    }



    }

