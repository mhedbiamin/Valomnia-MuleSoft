/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class ItemAttribute {

	private String organization;

	private String itemReference;

	private String value;

	private String displayOrder;

	private String attributeReference;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getAttributeReference() {
		return attributeReference;
	}

	public void setAttributeReference(String attributeReference) {
		this.attributeReference = attributeReference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeReference == null) ? 0 : attributeReference.hashCode());
		result = prime * result + ((itemReference == null) ? 0 : itemReference.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ItemAttribute other = (ItemAttribute) obj;
		if (attributeReference == null) {
			if (other.attributeReference != null)
				return false;
		} else if (!attributeReference.equals(other.attributeReference))
			return false;
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}