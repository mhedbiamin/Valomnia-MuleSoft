/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */

package org.mule.modules.valomnia.entities;

public class Order {

	private String delivaryPostalCode;

	private String delivaryCity;

	private String paymentDate;

	private String status;

	private String lastUpdated;

	private String totalProducts;

	private String customerReference;

	private String totalDiscounted;

	private String reference;

	private String discount;

	private String id;

	private String delivaryAddress;

	private String organization;

	private String deliveryComment;

	private String operationType;

	private String employeeReference;

	private String dateCreated;

	private String userReference;

	private String totalHT;

	private String deliveryDate;

	private String customerPaymentTypeReference;

	private String delivaryCountry;

	private String advanceAmount;

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

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDelivaryAddress() {
		return delivaryAddress;
	}

	public void setDelivaryAddress(String delivaryAddress) {
		this.delivaryAddress = delivaryAddress;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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

	public void setCustomerPaymentTypeReference(
			String customerPaymentTypeReference) {
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

	@Override
	public String toString() {
		return "ClassPojo [delivaryPostalCode = " + delivaryPostalCode
				+ ", delivaryCity = " + delivaryCity + ", paymentDate = "
				+ paymentDate + ", status = " + status + ", lastUpdated = "
				+ lastUpdated + ", totalProducts = " + totalProducts
				+ ", customerReference = " + customerReference
				+ ", totalDiscounted = " + totalDiscounted + ", reference = "
				+ reference + ", discount = " + discount + ", id = " + id
				+ ", delivaryAddress = " + delivaryAddress
				+ ", organization = " + organization + ", deliveryComment = "
				+ deliveryComment + ", operationType = " + operationType
				+ ", employeeReference = " + employeeReference
				+ ", dateCreated = " + dateCreated + ", userReference = "
				+ userReference + ", totalHT = " + totalHT
				+ ", deliveryDate = " + deliveryDate
				+ ", customerPaymentTypeReference = "
				+ customerPaymentTypeReference + ", delivaryCountry = "
				+ delivaryCountry + ", advanceAmount = " + advanceAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((customerReference == null) ? 0 : customerReference
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (organization == null) {
			if (other.organization != null) {
				return false;
			}
		} else if (!organization.equals(other.organization)) {
			return false;
		}
		if (reference == null) {
			if (other.reference != null) {
				return false;
			}
		} else if (!reference.equals(other.reference)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

}