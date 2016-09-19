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
