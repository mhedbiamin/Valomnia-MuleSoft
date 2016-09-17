/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
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