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
import org.mule.modules.valomnia.entities.ItemGroup;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeItemGroupTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemGroupTestCases() {
        super(ValomniaConnector.class);
    }
    @Test
    public void verify() {
    java.lang.String expected1 = "Success Updated";
    java.lang.String expected2 = "Success created";
    ItemGroup obj = new ItemGroup();

    boolean exist = false;

    List<ItemGroup> list = null ;
    try {
        list = getConnector().findItemsGroup();
    } catch (Exception e) {

        e.printStackTrace();
    }
    

    for (ItemGroup itemGroup : list)
    {
        if (itemGroup.getReference().equals("ref test ItemGroup"))
            exist = true;
    }
    obj.setName("test ItemGroup");
    
    obj.setReference("ref test ItemGroup");
    

    obj.setDescription("test description ItemGroup");

    if (exist)
        assertEquals(getConnector().mergeItemGroup(obj), expected1);
    else
        assertEquals(getConnector().mergeItemGroup(obj), expected2);
}

}


