/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.ItemUnit;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeItemUnitTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemUnitTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        ItemUnit obj = new ItemUnit();

        boolean exist = false;

        List<ItemUnit> list = null;
        try {
            list = getConnector().findItemUnits();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (ItemUnit itemUnit : list)
        {
            if (itemUnit.getItemReference()
                    .equals("ref test Item")&itemUnit.getUnitReference().equals("ref test Unit"))
                exist = true;
        }
        obj.setItemReference("ref test Item");
        obj.setUnitReference("ref test Unit");
        obj.setQuantity("1");
        obj.setSalesQty("7");
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeItemUnit(obj), expected2);
        else
            assertEquals(getConnector().mergeItemUnit(obj), expected1);
        
        /*change the  ItemUnit Quantity */
        obj.setQuantity("3");
        assertEquals(getConnector().mergeItemUnit(obj), expected1);
        /*change the  ItemUnit SalesQuanity*/
        obj.setSalesQty("10");
        assertEquals(getConnector().mergeItemUnit(obj), expected1);
        try {
            list = getConnector().findItemUnits();
        } catch (Exception e) {

            e.printStackTrace();
        }
        for (ItemUnit itemUnit : list)
        {
            if (itemUnit.getItemReference()
                    .equals("ref test Item")&itemUnit.getUnitReference().equals("ref test Unit"))
                obj=itemUnit;
        }
        assertEquals(obj.getQuantity(), "3");
        assertEquals(obj.getSalesQty(),"10");
        
        
    }
    
    
    @Test
    public void itemReferenceMissingTest() {
        java.lang.String expected = "itemReference required";
        
        ItemUnit obj = new ItemUnit();
        obj.setUnitReference("ref test Unit");
        obj.setQuantity("1");
        obj.setSalesQty("7");
        
  
            assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
        
    }
    @Test
    public void UnitReferenceMissingTest() {
        java.lang.String expected = "unitReference required";
        
        ItemUnit obj = new ItemUnit();
        obj.setItemReference("ref test Item");
        obj.setQuantity("1");
        
  
            assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
        
    }
    
    @Test 
    public void quantityItemUnitNotInteger()
    {  java.lang.String expected = "Quantity must be an Integer";
    ItemUnit obj = new ItemUnit();
    obj.setItemReference("ref test Item");
    obj.setUnitReference("ref test Unit");
    obj.setQuantity("A");
    

        assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
    
    }
    
   
    
    
    @Test 
    public void quantityItemUniNotGreaterThanZero()
    {  java.lang.String expected = "Quantity value must greater than 0";
    ItemUnit obj = new ItemUnit();
    obj.setItemReference("ref test Item");
    obj.setUnitReference("ref test Unit");
    obj.setQuantity("-9");
    

        assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
    
    }
    
    
    @Test 
    public void salesQuantityItemUnitNotInteger()
    {  java.lang.String expected = "Sales Quantity must be an Integer";
    ItemUnit obj = new ItemUnit();
    obj.setItemReference("ref test Item");
    obj.setUnitReference("ref test Unit");
    obj.setQuantity("6");
    obj.setSalesQty("A");

        assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
    
    }
    @Test 
    public void salesQuantityItemUniNotGreaterThanZero()
    {  java.lang.String expected = "Sales Quantity value must greater than 0";
    ItemUnit obj = new ItemUnit();
    obj.setItemReference("ref test Item");
    obj.setUnitReference("ref test Unit");
    obj.setQuantity("9");
    obj.setSalesQty("-5");
    

        assertTrue(getConnector().mergeItemUnit(obj).contains(expected));
    
    }
    @Test
    public void verifyItemUnitSaved() {
    	
    	List<ItemUnit> list = null;
    	boolean   exist=false;
        
            list = getConnector().findItemUnits();
        
        for (ItemUnit  itemUnit:list)
        { if (( itemUnit.getItemReference().equals("ref test Item"))&&(itemUnit.getUnitReference().equals("ref test Unit")))
            exist=true;
        }
    	assertTrue(exist);
    }

   

}