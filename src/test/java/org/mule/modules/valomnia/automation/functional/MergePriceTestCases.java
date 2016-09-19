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
import org.mule.modules.valomnia.entities.Price;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



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
       
        for (Price price : list)
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
        
        /*change the price value*/
        obj.setValue("7");
		assertEquals(getConnector().mergePrice(obj), expected1);
        
        try {
            list = getConnector().findPrices();
        } catch (Exception e) {

            e.printStackTrace();
        }
       
        for (Price price : list)
        {
            if (price.getItemReference()
                    .equals("ref test Item")&
                    price.getPriceListReference()
                    .equals("ref test PriceList")&
                    price.getUnitReference().equals("ref test Unit"))
                obj=price;
        }
        assertEquals(obj.getValue(),"7");
        
    }

@Test
public void missingItemReferenceTest() {
    java.lang.String expected = "itemReference missing: Failed to save the Price";
    
    Price obj = new Price(); 
    obj.setPriceListReference("ref test PriceList");
    obj.setUnitReference("ref test Unit");
    obj.setValue("1");

    String apiResponse=getConnector().mergePrice(obj);
        assertTrue(apiResponse.contains(expected ));
}

@Test
public void verifyPriceSaved() {
	
	List<Price> list = null;
	boolean   exist=false;
    
        list = getConnector().findPrices();
    
    for (Price  price:list)
    { if (( price.getItemReference().equals("ref test Item"))&&(price.getPriceListReference()
            .equals("ref test PriceList")))
        exist=true;
    }
	assertTrue(exist);
}
}