/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.WareHouse;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;




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
       

        for (WareHouse wareHouse : list)  
        {
            if (wareHouse.getReference().equals("ref test WareHouse"))
                    
                exist = true;
        }
        
        obj.setReference("ref test WareHouse");
        obj.setName("test name");
        
      obj.setAddress("test adress");

        

        if (exist)
            assertEquals(getConnector().mergeWareHouse(obj), expected1);
        else
            assertEquals(getConnector().mergeWareHouse(obj), expected2);
        /* change  warehouse adress */
        obj.setAddress("test adress Updated");
        assertEquals(getConnector().mergeWareHouse(obj), expected1);
        /* change  warehouse Name */
        obj.setName("test Name Updated");
        assertEquals(getConnector().mergeWareHouse(obj), expected1);
        try {
            list = getConnector().findWareHouses();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (WareHouse wareHouse : list)  
        {
            if (wareHouse.getReference().equals("ref test WareHouse"))
                    
                obj=wareHouse;
        }
        assertEquals(obj.getName(), "test Name Updated");
        assertEquals(obj.getAddress(), "test adress Updated");
        
    }
    
    @Test
    public void missingReferenceTest() {
        java.lang.String expected = "Reference missing";
        
        WareHouse obj = new WareHouse();   
        obj.setDescription("Test WareHouse ");
        obj.setName("test name");

        String apiResponse=getConnector().mergeWareHouse(obj);
            assertTrue(apiResponse.contains(expected ));
    }
    
    
    @Test
    public void missingNameTest() {
        java.lang.String expected = " name required";
        
        WareHouse obj = new WareHouse();   
        obj.setReference("ref test WareHouse");
        obj.setDescription("Test WareHouse ");
        
       

        String apiResponse=getConnector().mergeWareHouse(obj);
            assertTrue(apiResponse.contains(expected ));
    }
    
    @Test
    public void wareHouseParentNotFoundTest() {
        java.lang.String expected = "Warehouse Parent not found";
        
        WareHouse obj = new WareHouse();  
        obj.setReference("ref test WareHouse");
        obj.setDescription("Test WareHouse ");
        obj.setName("test name");
        obj.setParentReference("parent warehouse");
        String apiResponse=getConnector().mergeWareHouse(obj);
            assertTrue(apiResponse.contains(expected ));
    }
    
    @Test
    public void verifyWareHouseSaved() {
    	
    	List<WareHouse> list = null;
    	boolean   exist=false;
        
            list = getConnector().findWareHouses();
        
        for (WareHouse  wareHouse:list)
        { if ( wareHouse.getReference().equals("ref test WareHouse"))
            exist=true;
        }
    	assertTrue(exist);
    }



}