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
import org.mule.modules.valomnia.entities.ItemAttribute;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeItemAttributeTestCases extends
		AbstractTestCase<ValomniaConnector> {

	public MergeItemAttributeTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        ItemAttribute obj = new ItemAttribute();

        boolean exist = false;

        List<ItemAttribute> list = null;
        try {
            list = getConnector().findItemsAttribute();
        } catch (Exception e) {

            e.printStackTrace();
        }
        
       
        for (ItemAttribute itemAttribute : list)
        {   if (itemAttribute.getAttributeReference()!=null)
        {
            if (itemAttribute.getAttributeReference()
                    .equals("ref test Attribute") &  itemAttribute.getItemReference()
                    .equals("ref test Item"))
                exist = true;
        }
        }
        obj.setAttributeReference("ref test Attribute");
        obj.setItemReference("ref test Item");
        obj.setValue("S");
        

        if (!exist)
            assertEquals(getConnector().mergeItemAttribute(obj), expected2);
        else
            assertEquals(getConnector().mergeItemAttribute(obj), expected1);
    }


}