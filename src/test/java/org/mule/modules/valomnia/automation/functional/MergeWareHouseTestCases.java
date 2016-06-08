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
import org.mule.modules.valomnia.entities.WareHouse;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeWareHouseTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeWareHouseTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       WareHouse obj = new WareHouse();

        boolean exist = false;

        List<WareHouse> list = null;
        
        try {
            list = getConnector().findWareHouses();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<WareHouse>>() {}.getType();
        ArrayList<WareHouse> list1 = new Gson().fromJson(js, listType);

        for (WareHouse wareHouse : list1)  
        {
            if (wareHouse.getReference().equals("ref test WareHouse"))
                    
                exist = true;
        }
        
        obj.setReference("ref test WareHouse");
        obj.setName("test name");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeWareHouse(obj), expected1);
        else
            assertEquals(getConnector().mergeWareHouse(obj), expected2);
    }




}