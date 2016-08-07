/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Authority;


public class AuthorityTest {



	@Test
	public void testAuthorityAreEqual() {
		
		Authority  authority = new Authority();
		
		
		authority.setName("authority test");
		authority.setOrganization("test Organization");
		
		
		Authority  authority1 = new Authority();
	
		authority1.setName("authority test");
		authority1.setOrganization("test Organization");
		
		assertEquals(authority,authority1);
		
	}
	
	@Test
	public void testAuthorityAreNotEqual() {
		Authority  authority = new Authority();
	
		authority.setName("authority test");
		authority.setOrganization("test Organization");
		
		
		Authority  authority1 = new Authority();
		
		authority1.setName("authority test");
		authority1.setOrganization("test Organization 1");
		
		
		
		assertFalse(authority.equals(authority1));
		
	}
	
}