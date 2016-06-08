/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Employee {
	private String id;

	private String lastName;

	private String organization;

	private String lastUpdated;

	private String dateCreated;

	private String managerReference;

	private String avatar;

	private String firstName;

	private String employeeGroupReference;

	private String reference;

	private String mobile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getManagerReference() {
		return managerReference;
	}

	public void setManagerReference(String managerReference) {
		this.managerReference = managerReference;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmployeeGroupReference() {
		return employeeGroupReference;
	}

	public void setEmployeeGroupReference(String employeeGroupReference) {
		this.employeeGroupReference = employeeGroupReference;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", lastName = " + lastName
				+ ", organization = " + organization + ", lastUpdated = "
				+ lastUpdated + ", dateCreated = " + dateCreated
				+ ", managerReference = " + managerReference + ", avatar = "
				+ avatar + ", firstName = " + firstName
				+ ", employeeGroupReference = " + employeeGroupReference
				+ ", reference = " + reference + ", mobile = " + mobile + "]";
	}
}