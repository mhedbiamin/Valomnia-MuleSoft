/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.client;


import java.util.List;



public interface GenericValomniaClient<T> {

	/**
	 * Get all the elements
	 * 
	 * @return List of all the elements
	 
	 */

	List<T> getAll();

	/**
	 * save Or update the given element on Valomnia for the connected account
	 * 
	 * @param object
	 *            to be merged
	 * @return the created element
	 */

	String merge(Object object);

}
