/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.PriceList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergePriceListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergePriceListTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        PriceList obj = new PriceList();

        boolean exist = false;

        List<PriceList> list = null;
        try {
            list = getConnector().findPriceLists();
        } catch (Exception e) {

            e.printStackTrace();
        }
       
        for (PriceList priceList : list)
        {
            if (priceList.getReference()
                    .equals("ref test PriceList"))
                exist = true;
        }
        obj.setName("test name");
        
        obj.setReference("ref test PriceList");
       

        

        if (!exist)
            assertEquals(getConnector().mergePriceList(obj), expected2);
        else
            assertEquals(getConnector().mergePriceList(obj), expected1);
    }


}