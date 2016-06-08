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
import org.mule.modules.valomnia.entities.Price;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergePriceTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergePriceTestCases() {
        super(ValomniaConnector.class);
    }
@Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        Price obj = new Price();

        boolean exist = false;

        List<Price> list = null;
        try {
            list = getConnector().findPrices();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
       
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<Price>>() {}.getType();
        ArrayList<Price> list1 = new Gson().fromJson(js, listType);

        for (Price price : list1)
        {
            if (price.getItemReference()
                    .equals("ref test Item")&
                    price.getPriceListReference()
                    .equals("ref test PriceList")&
                    price.getUnitReference().equals("ref test Unit"))
                exist = true;
        }
        obj.setItemReference("ref test Item");
        
        obj.setPriceListReference("ref test PriceList");
        obj.setUnitReference("ref test Unit");
        obj.setValue("1");
       

        

        if (exist)
            assertEquals(getConnector().mergePrice(obj), expected1);
        else
            assertEquals(getConnector().mergePrice(obj), expected2);
    }

}