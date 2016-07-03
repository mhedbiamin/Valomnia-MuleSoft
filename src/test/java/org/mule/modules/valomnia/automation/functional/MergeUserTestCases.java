/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.User;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeUserTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeUserTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       User obj = new User();

        boolean exist = false;

        List<User> list = null;
        
        try {
            list = getConnector().findUsers();
        } catch (Exception e) {

            e.printStackTrace();
        }
        

        for (User user : list)
        {
            if (user.getEmail().equals("Test@valomnia.com"))
                    
                exist = true;
        }
        
        obj.setEmail("Test@valomnia.com");
        obj.setEmployeeReference("ref test Employee");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeUser(obj), expected1);
        else
            assertEquals(getConnector().mergeUser(obj), expected2);
    }



}