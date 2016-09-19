/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.entities;


import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CustomerCategoryTaxList {

private Integer id;
private Object taxListReference;
private String customerCategoryReference;
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
* The taxListReference
*/
public Object getTaxListReference() {
return taxListReference;
}

/**
* 
* @param taxListReference
* The taxListReference
*/
public void setTaxListReference(Object taxListReference) {
this.taxListReference = taxListReference;
}

/**
* 
* @return
* The customerCategoryReference
*/
public String getCustomerCategoryReference() {
return customerCategoryReference;
}

/**
* 
* @param customerCategoryReference
* The customerCategoryReference
*/
public void setCustomerCategoryReference(String customerCategoryReference) {
this.customerCategoryReference = customerCategoryReference;
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