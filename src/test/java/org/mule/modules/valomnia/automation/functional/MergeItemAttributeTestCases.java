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