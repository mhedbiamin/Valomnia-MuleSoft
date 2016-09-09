/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.entities;




public class Price {


private String priceListReference;
private String itemReference;
private String unitReference;
private String value;
private Object unitPrice;
private Object marginRate;
private String organization;



/**
* 
* @return
* The priceListReference
*/
public String getPriceListReference() {
return priceListReference;
}

/**
* 
* @param priceListReference
* The priceListReference
*/
public void setPriceListReference(String priceListReference) {
this.priceListReference = priceListReference;
}

/**
* 
* @return
* The itemReference
*/
public String getItemReference() {
return itemReference;
}

/**
* 
* @param itemReference
* The itemReference
*/
public void setItemReference(String itemReference) {
this.itemReference = itemReference;
}

/**
* 
* @return
* The unitReference
*/
public String getUnitReference() {
return unitReference;
}

/**
* 
* @param unitReference
* The unitReference
*/
public void setUnitReference(String unitReference) {
this.unitReference = unitReference;
}

/**
* 
* @return
* The value
*/
public String getValue() {
return value;
}

/**
* 
* @param value
* The value
*/
public void setValue(String value) {
this.value = value;
}

/**
* 
* @return
* The unitPrice
*/
public Object getUnitPrice() {
return unitPrice;
}

/**
* 
* @param unitPrice
* The unitPrice
*/
public void setUnitPrice(Object unitPrice) {
this.unitPrice = unitPrice;
}

/**
* 
* @return
* The marginRate
*/
public Object getMarginRate() {
return marginRate;
}

/**
* 
* @param marginRate
* The marginRate
*/
public void setMarginRate(Object marginRate) {
this.marginRate = marginRate;
}

/**
* 
* @return
* The organization
*/
public String getOrganization() {
return organization;
}

/**
* 
* @param organization
* The organization
*/
public void setOrganization(String organization) {
this.organization = organization;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Price other = (Price) obj;
	if (itemReference == null) {
		if (other.itemReference != null)
			return false;
	} else if (!itemReference.equals(other.itemReference))
		return false;
	if (marginRate == null) {
		if (other.marginRate != null)
			return false;
	} else if (!marginRate.equals(other.marginRate))
		return false;
	if (organization == null) {
		if (other.organization != null)
			return false;
	} else if (!organization.equals(other.organization))
		return false;
	if (priceListReference == null) {
		if (other.priceListReference != null)
			return false;
	} else if (!priceListReference.equals(other.priceListReference))
		return false;
	if (unitPrice == null) {
		if (other.unitPrice != null)
			return false;
	} else if (!unitPrice.equals(other.unitPrice))
		return false;
	if (unitReference == null) {
		if (other.unitReference != null)
			return false;
	} else if (!unitReference.equals(other.unitReference))
		return false;
	if (value == null) {
		if (other.value != null)
			return false;
	} else if (!value.equals(other.value))
		return false;
	return true;
}


}



