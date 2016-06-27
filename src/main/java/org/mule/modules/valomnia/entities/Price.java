/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.entities;




public class Price {

private Integer id;
private String priceListReference;
private String itemReference;
private String unitReference;
private String value;
private Object unitPrice;
private Object marginRate;
private String organization;
private String dateCreated;
private String lastUpdated;


/**
* 
* @return
* The id
*/
public Integer getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(Integer id) {
this.id = id;
}

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

/**
* 
* @return
* The dateCreated
*/
public String getDateCreated() {
return dateCreated;
}

/**
* 
* @param dateCreated
* The dateCreated
*/
public void setDateCreated(String dateCreated) {
this.dateCreated = dateCreated;
}

/**
* 
* @return
* The lastUpdated
*/
public String getLastUpdated() {
return lastUpdated;
}

/**
* 
* @param lastUpdated
* The lastUpdated
*/
public void setLastUpdated(String lastUpdated) {
this.lastUpdated = lastUpdated;
}



}
