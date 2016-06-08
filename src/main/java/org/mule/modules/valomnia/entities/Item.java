/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class Item {

	private Integer id;
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
	private String dateCreated;
	private String lastUpdated;

	/**
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	/**
	 * 
	 * @return The dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * 
	 * @param dateCreated
	 *            The dateCreated
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * @return The lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * 
	 * @param lastUpdated
	 *            The lastUpdated
	 */

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public  String isDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

}
