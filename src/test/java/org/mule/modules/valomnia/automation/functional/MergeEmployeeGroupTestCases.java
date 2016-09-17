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