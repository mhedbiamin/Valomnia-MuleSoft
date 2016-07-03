/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
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

}