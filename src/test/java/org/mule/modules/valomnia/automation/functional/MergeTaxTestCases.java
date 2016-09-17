/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Tax;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;




public class MergeTaxTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeTaxTestCases() {
        super(ValomniaConnector.class);
    }
    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
     Tax obj = new Tax();

        boolean exist = false;

        List<Tax> list = null;
        
        try {
            list = getConnector().findTaxs();
        } catch (Exception e) {

            e.printStackTrace();
        }
        

        for (Tax tax : list)
        {
            if ((tax.getItemReference()!=null) &&(tax.getItemReference().equals("ref test Item"))&(tax.getTaxListReference().equals("test TaxList Reference")))
                exist = true;
        }
        
        obj.setItemReference("ref test Item");
        obj.setTaxListReference("test TaxList Reference");
        obj.setTaxValue("16");;
       

        

        if (exist)
            assertEquals(getConnector().mergeTax(obj), expected1);
        else
            assertEquals(getConnector().mergeTax(obj), expected2);
    }



}