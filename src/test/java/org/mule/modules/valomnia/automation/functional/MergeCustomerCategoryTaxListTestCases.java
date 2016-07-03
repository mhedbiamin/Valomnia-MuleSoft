/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
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
                    (customerCategoryTaxList.getTaxListName().equals("test TaxList")))
                exist = true;
            
        }
        
        obj.setCustomerCategoryReference("ref test CustomerCategory");
        obj.setTaxListName("test TaxList");
        
        
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeCustomerCategoryTaxList(obj), expected2);
        else
            assertEquals(getConnector().mergeCustomerCategoryTaxList(obj), expected1);
    }



}