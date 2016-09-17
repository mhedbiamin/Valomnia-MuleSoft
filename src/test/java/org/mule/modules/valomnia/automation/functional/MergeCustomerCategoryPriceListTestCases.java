/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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