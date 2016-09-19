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
import org.mule.modules.valomnia.entities.CustomerCategoryPriceList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;


public class MergeCustomerCategoryPriceListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeCustomerCategoryPriceListTestCases() {
        super(ValomniaConnector.class);
    }

        
                @Test
                public void verify() {
                    java.lang.String expected1 = "Success Updated";
                    java.lang.String expected2 = "Success created";
                    CustomerCategoryPriceList obj = new CustomerCategoryPriceList();

                    boolean exist = false;

                    List<CustomerCategoryPriceList> list = null;
                    try {
                        list = getConnector().findCustomersCategoryPriceList();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                   
                    for (CustomerCategoryPriceList customerCategoryPriceList : list)
                    {
                        if (customerCategoryPriceList.getCustomerCategoryReference()
                                .equals("ref test CustomerCategory")& customerCategoryPriceList.getPriceListReference().equals("ref test PriceList"))
                            exist = true;
                    }
                    obj.setCustomerCategoryReference("ref test CustomerCategory");

                    obj.setPriceListReference("ref test PriceList");

                    if (!exist)
                        assertEquals(getConnector().mergeCustomerCategoryPriceList(obj), expected2);
                    else
                        assertEquals(getConnector().mergeCustomerCategoryPriceList(obj), expected1);
    }
}