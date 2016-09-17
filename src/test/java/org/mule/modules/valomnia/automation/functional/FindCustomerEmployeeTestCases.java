/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.CustomerEmployee;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class FindCustomerEmployeeTestCases extends AbstractTestCase<ValomniaConnector> {

    public FindCustomerEmployeeTestCases() {
        super(ValomniaConnector.class);
    }

    

    @Test
    public void verify() throws Exception {
            
            
            
            assertNotNull( getConnector().findCustomersEmployee());
            

            assertTrue(getConnector().findCustomersEmployee().size() > 0);
            for(Object obj:getConnector().findCustomersEmployee())
                assertTrue(obj.getClass().equals(CustomerEmployee.class));


    }
}