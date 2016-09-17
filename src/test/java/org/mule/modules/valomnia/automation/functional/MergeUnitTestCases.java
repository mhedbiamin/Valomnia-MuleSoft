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
import org.mule.modules.valomnia.entities.Unit;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeUnitTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeUnitTestCases() {
        super(ValomniaConnector.class);
    }

    

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Unit obj = new Unit();

        boolean exist = false;

        List<Unit> list = null;
        
        try {
            list = getConnector().findUnits();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (Unit unit : list)
        {
            if (unit.getReference().equals("ref test Unit"))
            
                    
                exist = true;
        }
        
        obj.setReference("ref test Unit");
        obj.setName("test name");;
       

        

        if (exist)
            assertEquals(getConnector().mergeUnit(obj), expected1);
        else
            assertEquals(getConnector().mergeUnit(obj), expected2);
    }



}