/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class WareHouseStock {

	private String organization;

	private String unitReference;

	private String itemReference;

	private String quantity;

	private String warehouseReference;

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

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getWarehouseReference() {
		return warehouseReference;
	}

	public void setWarehouseReference(String warehouseReference) {
		this.warehouseReference = warehouseReference;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WareHouseStock other = (WareHouseStock) obj;
		if (itemReference == null) {
			if (other.itemReference != null)
				return false;
		} else if (!itemReference.equals(other.itemReference))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitReference == null) {
			if (other.unitReference != null)
				return false;
		} else if (!unitReference.equals(other.unitReference))
			return false;
		if (warehouseReference == null) {
			if (other.warehouseReference != null)
				return false;
		} else if (!warehouseReference.equals(other.warehouseReference))
			return false;
		return true;
	}

}
