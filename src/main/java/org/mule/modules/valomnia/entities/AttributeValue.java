/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class AttributeValue {
	

	private String organization;

	private String color;

	private String value;

	
	private String displayOrder;

	private String attributeReference;

	

	

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
	public String toString() {
		return "ClassPojo [ organization = " + organization
				+ ", color = " + color + ", value = " + value
				+ ", displayOrder = " + displayOrder
				+ ", attributeReference = " + attributeReference + "]";
	}
}