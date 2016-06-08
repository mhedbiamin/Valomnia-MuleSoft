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
import org.mule.modules.valomnia.entities.AttributeValue;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeAttributeValueTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeAttributeValueTestCases() {
        super(ValomniaConnector.class);
    }


    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
     AttributeValue obj = new AttributeValue();

        boolean exist = false;

        List<AttributeValue> list = null;
        
        try {
            list = getConnector().findAttributesValue();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
       
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<AttributeValue>>() {}.getType();
        ArrayList<AttributeValue> list1 = new Gson().fromJson(js, listType);

        for (AttributeValue attributeValue: list1)
        {
            if (attributeValue.getAttributeReference()!=null)
                    if(attributeValue.getAttributeReference().equals("ref test Attribute")&attributeValue.getValue().equals("S"))
                    
                exist = true;
        }
        
        obj.setAttributeReference("ref test Attribute");
        obj.setValue("S");
        
        
        

        

        if (!exist)
            assertEquals(getConnector().mergeAttributeValue(obj), expected2);
        else
            assertEquals(getConnector().mergeAttributeValue(obj), expected1);
    }

}