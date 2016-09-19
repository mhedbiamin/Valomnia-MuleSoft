/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */




package org.mule.modules.valomnia.client;

public interface ValomniaClientProvider {
	


		<T> GenericValomniaClient<T> getClient(final Class<T> type);

	}


