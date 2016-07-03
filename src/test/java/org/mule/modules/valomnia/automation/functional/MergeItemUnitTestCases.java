/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.ItemUnit;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeItemUnitTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemUnitTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        ItemUnit obj = new ItemUnit();

        boolean exist = false;

        List<ItemUnit> list = null;
        try {
            list = getConnector().findItemUnits();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (ItemUnit itemUnit : list)
        {
            if (itemUnit.getItemReference()
                    .equals("ref test Item")&itemUnit.getUnitReference().equals("ref test Unit"))
                exist = true;
        }
        obj.setItemReference("ref test Item");
        obj.setUnitReference("ref test Unit");
        obj.setQuantity("1");
        
       

        

        if (!exist)
            assertEquals(getConnector().mergeItemUnit(obj), expected2);
        else
            assertEquals(getConnector().mergeItemUnit(obj), expected1);
    }

}