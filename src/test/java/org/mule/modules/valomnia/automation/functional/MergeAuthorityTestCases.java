/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Authority;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeAuthorityTestCases extends AbstractTestCase<ValomniaConnector> {

    public  MergeAuthorityTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Authority obj = new Authority();
        boolean exist = false;

        List<Authority> list = null;
        
        try {
            list = getConnector().findAuthority();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (Authority Authority : list)
        {
            if (Authority.getName().equals("test Authority"))
                    
                exist = true;
        }
        
        obj.setName("test Authority");
       

        

        if (exist)
            assertEquals(getConnector().mergeAuthority(obj), expected1);
        else
            assertEquals(getConnector().mergeAuthority(obj), expected2);
    }



    @Test
    public void verifyAuthoritySaved() {
    	
    	List<Authority> list = null;
    	boolean   exist=false;
        
            list = getConnector().findAuthority();
        
        for (Authority  authority:list)
        { if ( authority.getName().equals("test Authority"))
            exist=true;
        }
    	assertTrue(exist);
    }
    }


