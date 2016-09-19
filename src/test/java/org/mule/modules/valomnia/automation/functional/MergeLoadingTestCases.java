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
import org.mule.modules.valomnia.entities.Loading;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeLoadingTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeLoadingTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Loading obj = new Loading();
        boolean exist = false;

        List<Loading> list = null;
        
        try {
            list = getConnector().findLoadings();
        } catch (Exception e) {

            e.printStackTrace();
        }
        

        for (Loading loading : list)
        {
            if ((loading.getReference().equals("ref test Loading"))
            		&&(loading.getWarehouseReference().equals("ref test WareHouse")))
                   
                exist = true;
        }
        
        obj.setReference("ref test Loading");
        obj.setWarehouseReference("ref test WareHouse");
        obj.setType("1");
        obj.setWarehouseType("1");
       

        

        if (exist)
            assertEquals(getConnector().mergeLoading(obj), expected1);
        else
            assertEquals(getConnector().mergeLoading(obj), expected2);
    }

    @Test
	 public void  missingReferenceTest() {
	        java.lang.String expected = "Reference missing";
	        
	       Loading obj = new Loading();

	    
	        obj.setType("1");
	        obj.setWarehouseType("1");
	        obj.setWarehouseReference("ref test WareHouse");
	        
	        String apiResponse=getConnector().mergeLoading(obj);
	        assertTrue(apiResponse.contains(expected ));

	        

	       
	    }
    @Test
    public void verifyLoadingSaved() {
    	
    	List<Loading> list = null;
    	boolean   exist=false;
        
            list = getConnector().findLoadings();
        
        for (Loading  loading:list)
        { if ( loading.getReference().equals("ref test Loading"))
            exist=true;
        }
    	assertTrue(exist);
    }




    }

