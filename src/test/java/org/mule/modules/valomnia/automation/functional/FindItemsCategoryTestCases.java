/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.ItemCategory;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class FindItemsCategoryTestCases extends
		AbstractTestCase<ValomniaConnector> {

	public FindItemsCategoryTestCases() {
		super(ValomniaConnector.class);
	}

	 @Test
	    public void verify() throws Exception {
	            
	            
	            
	            assertNotNull( getConnector().findItemsCategory());
	            

	            assertTrue(getConnector().findItemsCategory().size() > 0);
	            
	            for(Object obj:getConnector().findItemsCategory())
	                assertTrue(obj.getClass().equals(ItemCategory.class));


	    }

	   
	}