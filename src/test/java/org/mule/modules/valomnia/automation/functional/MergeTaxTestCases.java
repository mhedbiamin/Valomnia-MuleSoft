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