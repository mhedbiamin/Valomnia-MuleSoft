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



