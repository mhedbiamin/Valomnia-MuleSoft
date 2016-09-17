/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.client.impl;

public class ValomniaAPIException extends RuntimeException {

	private static final long serialVersionUID = 7777L;

	public ValomniaAPIException(final String message) {
		super(message);
	}

	public ValomniaAPIException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ValomniaAPIException(final Throwable cause) {
		super(cause);
	}
}