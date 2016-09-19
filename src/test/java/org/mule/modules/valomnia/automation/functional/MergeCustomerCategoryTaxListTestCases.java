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
import org.mule.modules.valomnia.entities.CustomerCategoryTaxList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeCustomerCategoryTaxListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerCategoryTaxListTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
      CustomerCategoryTaxList obj = new CustomerCategoryTaxList();
        boolean exist = false;
       

        List<CustomerCategoryTaxList> list = null;
        
        try {
            list = getConnector().findCustomersCategoryTaxList();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (CustomerCategoryTaxList customerCategoryTaxList : list)
        {   if (customerCategoryTaxList.getCustomerCategoryReference()!=null)
        
            if ((customerCategoryTaxList.getCustomerCategoryReference().equals("ref test CustomerCategory"))&
                    (customerCategoryTaxList.getTaxListReference().equals("ref test TaxList")))
                exist = true;
            
        }
        
        obj.setCustomerCategoryReference("ref test CustomerCategory");
        obj.setTaxListReference("ref test TaxList");
       
       
        

        if (!exist)
            assertEquals(getConnector().mergeCustomerCategoryTaxList(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerCategoryTaxList(obj), expected1);
    }



}