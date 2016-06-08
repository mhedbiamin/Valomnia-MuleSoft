/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Price {
	private String id;

	private String organization;

	private String unitReference;

	private String priceListReference;

	private String itemReference;

	private String value;

	private String lastUpdated;

	private String dateCreated;

	private String unitPrice;

	private String marginRate;

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

	public String getUnitReference() {
		return unitReference;
	}

	public void setUnitReference(String unitReference) {
		this.unitReference = unitReference;
	}

	public String getPriceListReference() {
		return priceListReference;
	}

	public void setPriceListReference(String priceListReference) {
		this.priceListReference = priceListReference;
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

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(String marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", organization = " + organization
				+ ", unitReference = " + unitReference
				+ ", priceListReference = " + priceListReference
				+ ", itemReference = " + itemReference + ", value = " + value
				+ ", lastUpdated = " + lastUpdated + ", dateCreated = "
				+ dateCreated + ", unitPrice = " + unitPrice
				+ ", marginRate = " + marginRate + "]";
	}
}
