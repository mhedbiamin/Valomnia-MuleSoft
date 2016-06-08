package org.mule.modules.valomnia.client;

public interface ValomniaClientProvider {
	


		<T> GenericValomniaClient<T> getClient(final Class<T> type);

	}


