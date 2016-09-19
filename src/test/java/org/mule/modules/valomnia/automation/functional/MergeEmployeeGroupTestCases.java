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
import org.mule.modules.valomnia.entities.EmployeeGroup;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;


public class MergeEmployeeGroupTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeEmployeeGroupTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       EmployeeGroup obj = new EmployeeGroup();

        boolean exist = false;

        List<EmployeeGroup> list = null;
        try {
            list = getConnector().findEmployeeGroups();
        } catch (Exception e) {

            e.printStackTrace();
        }
  

        for (EmployeeGroup employeeGroup : list)
        {
            if (employeeGroup.getReference().equals("ref test EmployeeGroup"))
                    
                   
                exist = true;
        }
        obj.setReference("ref test EmployeeGroup");
        obj.setName("name EmployeeGroup");
        

        if (!exist)
            assertEquals(getConnector().mergeEmployeeGroup(obj), expected2);
        else
            assertEquals(getConnector().mergeEmployeeGroup(obj), expected1);
    }

}