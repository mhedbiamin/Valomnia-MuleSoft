/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Item;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeItemTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemTestCases() {
        super(ValomniaConnector.class);
    }

    
    
    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        Item obj = new Item();

        boolean exist = false;

        List<Item> list = null;
        try {
            list = getConnector().findItems();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<Item>>() {}.getType();
        ArrayList<Item> list1 = new Gson().fromJson(js, listType);

        for (Item item : list1)
        {
            if (item.getReference()
                    .equals("ref test Item"))
                exist = true;
        }
        obj.setName("test Item");
        obj.setOrganization("test");
        obj.setReference("ref test Item");
        obj.setCategoryReference("ref test ItemCategory");

        obj.setDescription("TEST DESCRIPTION");

        if (!exist)
            assertEquals(getConnector().mergeItem(obj), expected2);
        else
            assertEquals(getConnector().mergeItem(obj), expected1);
    }

}
