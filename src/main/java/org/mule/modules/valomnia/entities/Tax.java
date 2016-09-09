/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Tax {


	private String organization;

	private String itemReference;

	private String taxValue;

	private String taxListReference;

	

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}

	

	public String getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(String taxValue) {
		this.taxValue = taxValue;
	}

	public String getTaxListReference() {
		return taxListReference;
	}

	public void setTaxListReference(String taxListReference) {
		this.taxListReference = taxListReference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemReference == null) ? 0 : itemReference.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((taxListReference == null) ? 0 : taxListReference.hashCode());
		result = prime * result + ((taxValue == null) ? 0 : taxValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tax other = (Tax) obj;
		if (itemReference == null) {
			if (other.itemReference != null)
				return false;
		} else if (!itemReference.equals(other.itemReference))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (taxListReference == null) {
			if (other.taxListReference != null)
				return false;
		} else if (!taxListReference.equals(other.taxListReference))
			return false;
		if (taxValue == null) {
			if (other.taxValue != null)
				return false;
		} else if (!taxValue.equals(other.taxValue))
			return false;
		return true;
	}

	
}
