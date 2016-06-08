/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class OrderPayment {
	private String isLast;

	private String id;

	private String paymentDate;

	private String paymentReference;

	private String orderReference;

	private String lastUpdated;

	private String dateCreated;

	private String customerPaymentTypeReference;

	private String advanceAmount;

	public String getIsLast() {
		return isLast;
	}

	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
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

	public String getCustomerPaymentTypeReference() {
		return customerPaymentTypeReference;
	}

	public void setCustomerPaymentTypeReference(
			String customerPaymentTypeReference) {
		this.customerPaymentTypeReference = customerPaymentTypeReference;
	}

	public String getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	@Override
	public String toString() {
		return "ClassPojo [isLast = " + isLast + ", id = " + id
				+ ", paymentDate = " + paymentDate + ", paymentReference = "
				+ paymentReference + ", orderReference = " + orderReference
				+ ", lastUpdated = " + lastUpdated + ", dateCreated = "
				+ dateCreated + ", customerPaymentTypeReference = "
				+ customerPaymentTypeReference + ", advanceAmount = "
				+ advanceAmount + "]";
	}
}
