/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.ItemGroupAssign;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeItemGroupAssignTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemGroupAssignTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
    java.lang.String expected1 = "Success Updated";
    java.lang.String expected2 = "Success created";
    ItemGroupAssign obj = new ItemGroupAssign();

    boolean exist = false;

    List<ItemGroupAssign> list = null ;
    try {
        list = getConnector().findItemsGroupAssign();
    } catch (Exception e) {

        e.printStackTrace();
    }
   

    for (ItemGroupAssign itemGroupAssign : list)
    {
        if (itemGroupAssign.getItemGroupReference().equals("ref test ItemGroup")&
                itemGroupAssign.getItemReference().equals("ref test Item"))
            exist = true;
    }
    obj.setItemGroupReference("ref test ItemGroup");
    
    obj.setItemReference("ref test Item");
    

    

    if (!exist)
        assertEquals(getConnector().mergeItemGroupAssign(obj), expected2);
    else
        assertEquals(getConnector().mergeItemGroupAssign(obj), expected1);
}

}



