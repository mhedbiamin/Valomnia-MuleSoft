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
import org.mule.modules.valomnia.entities.Employee;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeEmployeeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeEmployeeTestCases() {
        super(ValomniaConnector.class);
    }

    
            @Test
            public void verify() {
                java.lang.String expected1 = "Success Updated";
                java.lang.String expected2 = "Success created";
                Employee obj = new Employee();

                boolean exist = false;

                List<Employee> list = null;
                try {
                    list = getConnector().findEmployees();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                

                for (Employee employee : list)
                {
                    if (employee.getReference()
                            .equals("ref test Employee"))
                        exist = true;
                }
                obj.setFirstName("test Item");
                
                obj.setReference("ref test Employee");
                obj.setFirstName("test First Name");

                obj.setLastName("test Last Name");

                if (!exist)
                    assertEquals(getConnector().mergeEmployee(obj), expected2);
                else
                    assertEquals(getConnector().mergeEmployee(obj), expected1);
            }

            @Test
            public void missingReferenceTest() {
                java.lang.String expected = "Reference missing";
               
                Employee obj = new Employee();

                
                obj.setFirstName("test Item");
                obj.setFirstName("test First Name");

                obj.setLastName("test Last Name");

               
                    assertTrue(getConnector().mergeEmployee(obj).contains(expected));
               
            }
            
            
            @Test
            public void verifyEmployeeSaved() {
            	
            	List<Employee> list = null;
            	boolean   exist=false;
                
                    list = getConnector().findEmployees();
                
                for (Employee  employee:list)
                { if ( employee.getReference().equals("ref test Employee"))
                    exist=true;
                }
            	assertTrue(exist);
            }


        }       

