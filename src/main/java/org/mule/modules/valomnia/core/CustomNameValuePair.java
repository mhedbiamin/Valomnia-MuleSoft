/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.core;

import org.apache.http.NameValuePair;
import org.apache.http.util.LangUtils;

public class CustomNameValuePair implements NameValuePair {

	private final String name;
	private final String value;

	public CustomNameValuePair(String name, String value) {
		super();
		if (name == null) {
			throw new IllegalArgumentException("Name should not be null");
		}
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	public String toString() {
		if (this.value == null) {
			return name;
		} else {
			StringBuilder buffer = new StringBuilder();
			buffer.append(this.name);
			buffer.append("=");
			buffer.append("\"");
			buffer.append(this.value);
			buffer.append("\"");
			return buffer.toString();
		}
	}

	public boolean equals(final Object object) {
		if (this == object){
			return true;
		}
		if (object instanceof CustomNameValuePair) {
			CustomNameValuePair that = (CustomNameValuePair) object;
			return this.name.equals(that.name)
					&& LangUtils.equals(this.value, that.value);
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hash = LangUtils.HASH_SEED;
		hash = LangUtils.hashCode(hash, this.name);
		hash = LangUtils.hashCode(hash, this.value);
		return hash;
	}
}