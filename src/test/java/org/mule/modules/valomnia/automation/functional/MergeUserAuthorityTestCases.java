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
import org.mule.modules.valomnia.entities.UserAuthority;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeUserAuthorityTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeUserAuthorityTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       UserAuthority obj = new UserAuthority();
        boolean exist = false;

        List<UserAuthority> list = null;
        
        try {
            list = getConnector().findUsersAuthority();
        } catch (Exception e) {

            e.printStackTrace();
        }
        
       

        for (UserAuthority userAuthority : list)
        {
            if (userAuthority.getAuthorityName().equals("test Authority")&userAuthority.getUserEmail().equals("Test@valomnia.com"))
                    
                exist = true;
        }
        
        obj.setAuthorityName("test Authority");
        obj.setUserEmail("Test@valomnia.com");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeUserAuthority(obj), expected1);
        else
            assertEquals(getConnector().mergeUserAuthority(obj), expected2);
    }



    }
