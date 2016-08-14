/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Attribute;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeAttributeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeAttributeTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        
            java.lang.String expected1 = "Success Updated";
            java.lang.String expected2 = "Success created";
         Attribute obj = new Attribute();

            boolean exist = false;

            List<Attribute> list = null;
            
            try {
                list = getConnector().findAttributs();
            } catch (Exception e) {

                e.printStackTrace();
            }
           

            for (Attribute attribute: list)
            {
                if( attribute.getReference()!=null)
                        if (attribute.getReference().equals("ref test Attribute"))
                        
           
                    exist = true;
}
            obj.setReference("ref test Attribute");
            obj.setName("test name  Attribute");
            obj.setType("COLOR");
            
            

            

            if (!exist)
                assertEquals(getConnector().mergeAttribute(obj), expected2);
            else
                assertEquals(getConnector().mergeAttribute(obj), expected1);
        }
    
    
    @Test
    public void misssingReference() {
        java.lang.String expected = "Reference missing: Failed to save the Attribute";
        
        Attribute obj = new Attribute();
       
        obj.setName("test name  Attribute");
        obj.setType("COLOR");   
            assertTrue(getConnector().mergeAttribute(obj).contains(expected));
        
    }

    @Test
    public void typeAttributeTest() {
        java.lang.String expected = "type can have only these values [ COLOR, STRING, NUMBER ]";
        
        Attribute obj = new Attribute();
        obj.setReference("ref test Attribute 1");
        obj.setName("test name  Attribute");
        obj.setType("value");   
            assertTrue(getConnector().mergeAttribute(obj).contains(expected));
        
    }
   
    
 
    @Test
    public void verifyAttributeSaved() {
    	
    	List<Attribute> list = null;
    	boolean   exist=false;
        
            list = getConnector().findAttributs();
        
        for (Attribute  attribute:list)
        { if ( attribute.getReference().equals("ref test Attribute"))
            exist=true;
        }
    	assertTrue(exist);
    }
}