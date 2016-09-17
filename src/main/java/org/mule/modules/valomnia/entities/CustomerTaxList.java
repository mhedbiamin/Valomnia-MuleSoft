/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.entities;

public class CustomerTaxList {

	private String customerReference;

	private String taxListReference;

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getTaxListReference() {
		return taxListReference;
	}

	public void setTaxListReference(String taxListReference) {
		this.taxListReference = taxListReference;
	}

}
