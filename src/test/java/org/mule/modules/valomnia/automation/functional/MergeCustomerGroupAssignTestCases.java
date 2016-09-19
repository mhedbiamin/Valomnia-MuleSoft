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
import org.mule.modules.valomnia.entities.CustomerGroupAssign;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeCustomerGroupAssignTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerGroupAssignTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
      CustomerGroupAssign obj = new CustomerGroupAssign();

        boolean exist = false;
       

        List<CustomerGroupAssign> list = null;
        
        try {
            list = getConnector().findCustomersGroupAssign();
        } catch (Exception e) {

            e.printStackTrace();
        }
       
        for (CustomerGroupAssign customgroupAssign : list)
        {
            if ((customgroupAssign.getCustomerReference().equals("ref test Customer"))&
                    (customgroupAssign.getCustomerGroupReference().equals("ref test CustomerGroup")))
                exist = true;
        }
        
        obj.setCustomerReference("ref test Customer");
        obj.setCustomerGroupReference("ref test CustomerGroup");
        
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerGroupAssign(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerGroupAssign(obj), expected1);
    }
    
    @Test
    public void verifyCustomerGroupAssignSaved() {
    	
    	List<CustomerGroupAssign> list = null;
    	boolean   exist=false;
        
            list = getConnector().findCustomersGroupAssign();
        
        for (CustomerGroupAssign customerGroupAssign:list)
        { if ( customerGroupAssign.getCustomerReference().equals("ref test Customer")&&  
        		customerGroupAssign.getCustomerGroupReference().equals("ref test CustomerGroup"))
            exist=true;
        }
    	assertTrue(exist);
    }



    }

