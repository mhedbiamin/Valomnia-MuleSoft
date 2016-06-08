/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Authority;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class FindAuthorityTestCases extends AbstractTestCase<ValomniaConnector> {

    public FindAuthorityTestCases() {
        super(ValomniaConnector.class);
    }


    @Test
    public void verify() throws Exception {
            
            
            
            assertNotNull( getConnector().findAuthority());
            

            assertTrue(getConnector().findAuthority().size() > 0);
            for(Object obj:getConnector().findAuthority())
                assertTrue(obj.getClass().equals(Authority.class));


    }
}