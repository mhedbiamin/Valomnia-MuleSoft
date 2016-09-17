/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */


package org.mule.modules.valomnia.entities;

public class Price {

	private String priceListReference;
	private String itemReference;
	private String unitReference;
	private String value;
	private Object unitPrice;
	private Object marginRate;

	/**
	 * 
	 * @return The priceListReference
	 */
	public String getPriceListReference() {
		return priceListReference;
	}

	/**
	 * 
	 * @param priceListReference
	 *            The priceListReference
	 */
	public void setPriceListReference(String priceListReference) {
		this.priceListReference = priceListReference;
	}

	/**
	 * 
	 * @return The itemReference
	 */
	public String getItemReference() {
		return itemReference;
	}

	/**
	 * 
	 * @param itemReference
	 *            The itemReference
	 */
	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}

	/**
	 * 
	 * @return The unitReference
	 */
	public String getUnitReference() {
		return unitReference;
	}

	/**
	 * 
	 * @param unitReference
	 *            The unitReference
	 */
	public void setUnitReference(String unitReference) {
		this.unitReference = unitReference;
	}

	/**
	 * 
	 * @return The value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            The value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @return The unitPrice
	 */
	public Object getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 
	 * @param unitPrice
	 *            The unitPrice
	 */
	public void setUnitPrice(Object unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 
	 * @return The marginRate
	 */
	public Object getMarginRate() {
		return marginRate;
	}

	/**
	 * 
	 * @param marginRate
	 *            The marginRate
	 */
	public void setMarginRate(Object marginRate) {
		this.marginRate = marginRate;
	}

	/**
	 * 
	 * @return The organization
	 */

}
