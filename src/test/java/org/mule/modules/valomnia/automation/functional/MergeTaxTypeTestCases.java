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
import org.mule.modules.valomnia.entities.TaxType;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeTaxTypeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeTaxTypeTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       TaxType obj = new TaxType();

        boolean exist = false;

        List<TaxType> list = null;
        
        try {
            list = getConnector().findTaxTypes();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<TaxType>>() {}.getType();
        ArrayList<TaxType> list1 = new Gson().fromJson(js, listType);

        for (TaxType taxType: list1)  
        {
            if (taxType.getName().equals("test TaxType"))
                    
                exist = true;
        }
        
        
        obj.setName("test TaxType");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeTaxType(obj), expected1);
        else
            assertEquals(getConnector().mergeTaxType(obj), expected2);
    }


}