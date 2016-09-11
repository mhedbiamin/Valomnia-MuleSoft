/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Customer {

	private String phone;

	private String maxChequeValue;

	private String invoicesPerRoute;

	private String creditLimit;

	private String isCredit;

	private String city;

	private String balance;

	private String postalCode;

	private String name;

	private String longitude;

	private String categoryReference;

	private String logo;

	private String fax;

	private String website;

	private String maxChequePeriod;

	private String paymentTerm;

	private String appliedCashBackOutput;

	private String reference;

	private String barecode;

	private String country;

	private String isActive;

	private String email;

	private String address;

	private String userReference;

	private String latitude;

	private String comment;

	private String returnDiscount;

	private String mobile;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMaxChequeValue() {
		return maxChequeValue;
	}

	public void setMaxChequeValue(String maxChequeValue) {
		this.maxChequeValue = maxChequeValue;
	}

	public String getInvoicesPerRoute() {
		return invoicesPerRoute;
	}

	public void setInvoicesPerRoute(String invoicesPerRoute) {
		this.invoicesPerRoute = invoicesPerRoute;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(String isCredit) {
		this.isCredit = isCredit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Object getCategoryReference() {
		return categoryReference;
	}

	public void setCategoryReference(String categoryReference) {
		this.categoryReference = categoryReference;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMaxChequePeriod() {
		return maxChequePeriod;
	}

	public void setMaxChequePeriod(String maxChequePeriod) {
		this.maxChequePeriod = maxChequePeriod;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getAppliedCashBackOutput() {
		return appliedCashBackOutput;
	}

	public void setAppliedCashBackOutput(String appliedCashBackOutput) {
		this.appliedCashBackOutput = appliedCashBackOutput;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getBarecode() {
		return barecode;
	}

	public void setBarecode(String barecode) {
		this.barecode = barecode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserReference() {
		return userReference;
	}

	public void setUserReference(String userReference) {
		this.userReference = userReference;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReturnDiscount() {
		return returnDiscount;
	}

	public void setReturnDiscount(String returnDiscount) {
		this.returnDiscount = returnDiscount;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

}