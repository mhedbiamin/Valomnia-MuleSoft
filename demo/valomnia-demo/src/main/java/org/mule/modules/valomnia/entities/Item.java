/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Item {

	private String reference;
	private String organization;
	private String name;
	private String parentReference;
	private String categoryReference;
	private String description;
	private String displayOrder;

	private String isActive;
	private String image1;
	private String image2;
	private String image3;
	

	
	/**
	 * 
	 * @return The reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * 
	 * @param reference
	 *            The reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * 
	 * @return The organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * 
	 * @param organization
	 *            The organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The parentReference
	 */
	public Object getParentReference() {
		return parentReference;
	}

	/**
	 * 
	 * @param parentReference
	 *            The parentReference
	 */
	public void setParentReference(String parentReference) {
		this.parentReference = parentReference;
	}

	/**
	 * 
	 * @return The categoryReference
	 */
	public String getCategoryReference() {
		return categoryReference;
	}

	/**
	 * 
	 * @param categoryReference
	 *            The categoryReference
	 */
	public void setCategoryReference(String categoryReference) {
		this.categoryReference = categoryReference;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The isActive
	 */
	public String  getIsActive() {
		return isActive;
	}

	/**
	 * 
	 * @param isActive
	 *            The isActive
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * 
	 * @return The image1
	 */
	public String getImage1() {
		return image1;
	}

	/**
	 * 
	 * @param image1
	 *            The image1
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}

	/**
	 * 
	 * @return The image2
	 */
	public Object getImage2() {
		return image2;
	}

	/**
	 * 
	 * @param image2
	 *            The image2
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}

	/**
	 * 
	 * @return The image3
	 */
	public Object getImage3() {
		return image3;
	}

	/**
	 * 
	 * @param image3
	 *            The image3
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}

	

	

	public  String isDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
			}
		Item other = (Item) obj;
		if (categoryReference == null) {
			if (other.categoryReference != null)
			{
				return false;
			}
		} else if (!categoryReference.equals(other.categoryReference)){
			return false;
			}
		
		if (name == null) {
			if (other.name != null){
				return false;
				}
		} else if (!name.equals(other.name)){
			return false;
			}
		if (reference == null) {
			if (other.reference != null){
				return false;
				}
		} else if (!reference.equals(other.reference)){
			return false;
			}
		return true;
	}





@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoryReference == null) ? 0 : categoryReference
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		return result;
	}




}

