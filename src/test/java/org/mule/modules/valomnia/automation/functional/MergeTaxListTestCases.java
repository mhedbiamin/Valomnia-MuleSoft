/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;




import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.TaxList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeTaxListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeTaxListTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
      TaxList obj = new TaxList();

        boolean exist = false;

        List<TaxList> list = null;
        
        try {
            list = getConnector().findTaxLists();
        } catch (Exception e) {

            e.printStackTrace();
        }
      

        for (TaxList taxList : list)
        {
            if (taxList.getName().equals("test TaxList"))
            
                    
                exist = true;
        }
        
        obj.setName("test TaxList");
        obj.setTaxType("Pourcentage %");
        obj.setReference("ref test TaxList");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeTaxList(obj), expected1);
        else
            assertEquals(getConnector().mergeTaxList(obj), expected2);
    }



}