/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class User {

	private String enabled;

	private String organization;

	private String email;

	private String employeeReference;

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeReference() {
		return employeeReference;
	}

	public void setEmployeeReference(String employeeReference) {
		this.employeeReference = employeeReference;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeReference == null) {
			if (other.employeeReference != null)
				return false;
		} else if (!employeeReference.equals(other.employeeReference))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}

}
