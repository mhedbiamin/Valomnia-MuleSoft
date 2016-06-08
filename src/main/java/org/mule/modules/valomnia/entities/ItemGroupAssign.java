/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class ItemGroupAssign {
	private String id;

	private String organization;

	private String itemReference;

	private String lastUpdated;

	private String dateCreated;

	private String itemGroupReference;

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

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
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

	public String getItemGroupReference() {
		return itemGroupReference;
	}

	public void setItemGroupReference(String itemGroupReference) {
		this.itemGroupReference = itemGroupReference;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", organization = " + organization
				+ ", itemReference = " + itemReference + ", lastUpdated = "
				+ lastUpdated + ", dateCreated = " + dateCreated
				+ ", itemGroupReference = " + itemGroupReference + "]";
	}
}
