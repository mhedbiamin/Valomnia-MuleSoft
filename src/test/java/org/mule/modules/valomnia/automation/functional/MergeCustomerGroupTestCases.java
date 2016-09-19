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
import org.mule.modules.valomnia.entities.CustomerGroup;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeCustomerGroupTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerGroupTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       CustomerGroup obj = new CustomerGroup();

        boolean exist = false;

        List<CustomerGroup> list = null;
        
        try {
            list = getConnector().findCustomersGroup();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (CustomerGroup customerGroup: list)
        {
            if (customerGroup.getReference().equals("ref test CustomerGroup"))
                    
                exist = true;
        }
        
        obj.setReference("ref test CustomerGroup");
        obj.setName("test name  CustomerGroup");
        

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerGroup(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerGroup(obj), expected1);
    }


    
    @Test
    public void verifyCustomerGroupSaved() {
    	
    	List<CustomerGroup> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersGroup();
        
        for (CustomerGroup customerGroup:list)
        { if ( customerGroup.getReference().equals("ref test CustomerGroup")&&  
        		customerGroup.getName().equals("test name  CustomerGroup"))
            exist=true;
        }
    	assertTrue(exist);
    }


    }


