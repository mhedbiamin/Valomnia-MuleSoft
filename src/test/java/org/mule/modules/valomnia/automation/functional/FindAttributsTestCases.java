/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Attribute;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class FindAttributsTestCases extends AbstractTestCase<ValomniaConnector> {

    public FindAttributsTestCases() {
        super(ValomniaConnector.class);
    }

    
    
    @Test
    public void verify() throws Exception {
            
            
            
            assertNotNull( getConnector().findAttributs());
            

            assertTrue(getConnector().findAttributs().size() > 0);
            for(Object obj:getConnector().findAttributs())
            assertTrue(obj.getClass().equals(Attribute.class));

    }
}