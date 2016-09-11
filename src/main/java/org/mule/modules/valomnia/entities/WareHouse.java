/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class WareHouse {

	private String address;

	private String description;

	private String employeeReference;

	private String name;

	private String isVan;

	private String parentReference;

	private String reference;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeReference() {
		return employeeReference;
	}

	public void setEmployeeReference(String employeeReference) {
		this.employeeReference = employeeReference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsVan() {
		return isVan;
	}

	public void setIsVan(String isVan) {
		this.isVan = isVan;
	}

	public String getParentReference() {
		return parentReference;
	}

	public void setParentReference(String parentReference) {
		this.parentReference = parentReference;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
