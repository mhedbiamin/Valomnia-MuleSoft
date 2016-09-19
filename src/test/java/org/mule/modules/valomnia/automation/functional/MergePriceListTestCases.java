/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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