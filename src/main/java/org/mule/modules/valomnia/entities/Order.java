/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.entities;

public class Order {

	private String delivaryPostalCode;

	private String delivaryCity;

	private String paymentDate;

	private String status;

	private String totalProducts;

	private String customerReference;

	private String totalDiscounted;

	private String reference;

	private String discount;

	private String delivaryAddress;

	private String deliveryComment;

	private String operationType;

	private String employeeReference;

	private String userReference;

	private String totalHT;

	private String deliveryDate;

	private String customerPaymentTypeReference;

	private String delivaryCountry;

	private String advanceAmount;
	private String deliveryStatus;

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDelivaryPostalCode() {
		return delivaryPostalCode;
	}

	public void setDelivaryPostalCode(String delivaryPostalCode) {
		this.delivaryPostalCode = delivaryPostalCode;
	}

	public String getDelivaryCity() {
		return delivaryCity;
	}

	public void setDelivaryCity(String delivaryCity) {
		this.delivaryCity = delivaryCity;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(String totalProducts) {
		this.totalProducts = totalProducts;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getTotalDiscounted() {
		return totalDiscounted;
	}

	public void setTotalDiscounted(String totalDiscounted) {
		this.totalDiscounted = totalDiscounted;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDelivaryAddress() {
		return delivaryAddress;
	}

	public void setDelivaryAddress(String delivaryAddress) {
		this.delivaryAddress = delivaryAddress;
	}

	public String getDeliveryComment() {
		return deliveryComment;
	}

	public void setDeliveryComment(String deliveryComment) {
		this.deliveryComment = deliveryComment;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getEmployeeReference() {
		return employeeReference;
	}

	public void setEmployeeReference(String employeeReference) {
		this.employeeReference = employeeReference;
	}

	public String getUserReference() {
		return userReference;
	}

	public void setUserReference(String userReference) {
		this.userReference = userReference;
	}

	public String getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(String totalHT) {
		this.totalHT = totalHT;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomerPaymentTypeReference() {
		return customerPaymentTypeReference;
	}

	public void setCustomerPaymentTypeReference(String customerPaymentTypeReference) {
		this.customerPaymentTypeReference = customerPaymentTypeReference;
	}

	public String getDelivaryCountry() {
		return delivaryCountry;
	}

	public void setDelivaryCountry(String delivaryCountry) {
		this.delivaryCountry = delivaryCountry;
	}

	public String getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

}