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
import org.mule.modules.valomnia.entities.Contact;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MergeContactTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeContactTestCases() {
        super(ValomniaConnector.class);
    }

   

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
       Contact obj = new Contact();

        boolean exist = false;

        List<Contact> list = null;
        
        try {
            list = getConnector().findContacts();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson gson = new Gson();
        String js = gson.toJson(list);
        @SuppressWarnings("serial")
        Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
        ArrayList<Contact> list1 = new Gson().fromJson(js, listType);

        for (Contact contact : list1)
        {
            if (contact.getCustomerReference().equals("ref test Customer")&contact.getFirstName().equals("test first name")&
            contact.getLastName().equals("test last name"))
                    
                exist = true;
        }
        
        obj.setCustomerReference("ref test Customer");
        obj.setFirstName("test first name");
        obj.setLastName("test last name");;
       

        

        if (exist)
            assertEquals(getConnector().mergeContact(obj), expected1);
        else
            assertEquals(getConnector().mergeContact(obj), expected2);
    }



    }

