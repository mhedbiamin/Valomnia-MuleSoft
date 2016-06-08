/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class OrderDetail {
	private String itemName;

	private String itemCategoryReference;

	private String orderReference;

	private String lastUpdated;

	private String unitPrice;

	private String customerReference;

	private String finalPrice;

	private String discount;

	private String id;

	private String organization;

	private String tax;

	private String unitReference;

	private String itemReference;

	private String dateCreated;

	private String quantity;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategoryReference() {
		return itemCategoryReference;
	}

	public void setItemCategoryReference(String itemCategoryReference) {
		this.itemCategoryReference = itemCategoryReference;
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

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getUnitReference() {
		return unitReference;
	}

	public void setUnitReference(String unitReference) {
		this.unitReference = unitReference;
	}

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ClassPojo [itemName = " + itemName
				+ ", itemCategoryReference = " + itemCategoryReference
				+ ", orderReference = " + orderReference + ", lastUpdated = "
				+ lastUpdated + ", unitPrice = " + unitPrice
				+ ", customerReference = " + customerReference
				+ ", finalPrice = " + finalPrice + ", discount = " + discount
				+ ", id = " + id + ", organization = " + organization
				+ ", tax = " + tax + ", unitReference = " + unitReference
				+ ", itemReference = " + itemReference + ", dateCreated = "
				+ dateCreated + ", quantity = " + quantity + "]";
	}
}
