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