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
import org.mule.modules.valomnia.entities.Contact;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



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
        

        for (Contact contact : list)
        {
            if (contact.getCustomerReference().equals("ref test Customer")&contact.getFirstName().equals("test first name")&
            contact.getLastName().equals("test last name"))
                    
                exist = true;
        }
        
        obj.setCustomerReference("ref test Customer");
        obj.setFirstName("test first name");
        obj.setLastName("test last name");
       

        

        if (exist)
            assertEquals(getConnector().mergeContact(obj), expected1);
        else
            assertEquals(getConnector().mergeContact(obj), expected2);
    }
    
    
    @Test
    public void missingCustomerReference() {
        java.lang.String expected = "customerReference missing";
        
       Contact obj = new Contact();
        obj.setFirstName("test first name");
        obj.setLastName("test last name");
     assertTrue(getConnector().mergeContact(obj).contains(expected));
    }
    @Test
    public void missingFirstName() {
        java.lang.String expected = "firstName missing: Failed to save the Contact ";
        
       Contact obj = new Contact();
       obj.setCustomerReference("ref test Customer");
        obj.setLastName("test last name");
       

        

            assertTrue(getConnector().mergeContact(obj).contains(expected));
    }
    
    
    @Test
    public void missingLastName() {
        java.lang.String expected = "lastName missing: Failed to save the Contact ";
        
       Contact obj = new Contact();
       obj.setCustomerReference("ref test Customer");
       obj.setFirstName("test first name");

            assertTrue(getConnector().mergeContact(obj).contains(expected));
    }
        
    @Test
    public void verifyContactSaved() {
    	
    	List<Contact> list = null;
    	boolean   exist=false;
        
            list = getConnector().findContacts();
        
        for (Contact  contact:list)
        { if( ( contact.getCustomerReference().equals("ref test Customer"))
        	&& ( contact.getFirstName().equals("test first name"))&&  ( contact.getLastName().equals("test last name")))
            exist=true;
        }
    	assertTrue(exist);
    }


    }

