/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
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