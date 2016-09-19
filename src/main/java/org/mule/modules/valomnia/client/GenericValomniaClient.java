/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
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
