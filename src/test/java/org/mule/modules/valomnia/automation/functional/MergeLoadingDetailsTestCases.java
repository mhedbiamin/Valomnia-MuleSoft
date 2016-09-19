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
import org.mule.modules.valomnia.entities.LoadingDetails;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeLoadingDetailsTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeLoadingDetailsTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       LoadingDetails obj = new LoadingDetails();
        boolean exist = false;

        List<LoadingDetails> list = null;
        
        try {
            list = getConnector().findLoadingDetails();
        } catch (Exception e) {

            e.printStackTrace();
        }
        

        for (LoadingDetails loadingDetails : list)
        {
            if (loadingDetails.getLoadingReference().equals("ref test Loading")&
                    loadingDetails.getItemReference().equals("ref test Item")&
                    loadingDetails.getUnitReference().equals("ref test Unit"))
                    
                exist = true;
        }
        
        obj.setLoadingReference("ref test Loading");
        obj.setItemReference("ref test Item");
        obj.setUnitReference("ref test Unit");
        obj.setQuantity("10");
       

        

        if (exist)
            assertEquals(getConnector().mergeLoadingDetails(obj), expected1);
        else
            assertEquals(getConnector().mergeLoadingDetails(obj), expected2);
    }
    
    @Test
    public void itemReferenceMissingTest() {
        java.lang.String expected = "itemReference missing: Failed to save the LoadingDetails";
        LoadingDetails obj = new LoadingDetails();
        obj.setLoadingReference("ref test Loading");
        obj.setUnitReference("ref test Unit");
        obj.setQuantity("10");
  
            assertTrue(getConnector().mergeLoadingDetails(obj).contains(expected));
        
    }
    
    @Test
    public void verifyLoadingDetailsSaved() {
    	
    	List<LoadingDetails> list = null;
    	boolean   exist=false;
        
            list = getConnector().findLoadingDetails();
        
        for (LoadingDetails  loadingDetails:list)
        { if( (loadingDetails.getLoadingReference().equals("ref test Loading"))&&( loadingDetails.getItemReference().equals("ref test Item"))&&(loadingDetails.getUnitReference().equals("ref test Unit")))
            exist=true;
        }
    	assertTrue(exist);
    }

}