/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
/**
 *
 */
package org.mule.modules.valomnia.entities;

public class ItemUnit {
    private String id;

    private String organization;

    private String isDefault;

    private String unitReference;

    private String defaultDisplay;

    private String itemReference;

    private String lastUpdated;

    private String dateCreated;

    private String barcode;

    private String quantity;

    public String getId () {
        return id;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getOrganization () {
        return organization;
    }

    public void setOrganization (String organization) {
        this.organization = organization;
    }

    public String getIsDefault (){
        return isDefault;
    }

    public void setIsDefault (String isDefault){
        this.isDefault = isDefault;
    }

    public String getUnitReference (){
        return unitReference;
    }

    public void setUnitReference (String unitReference) {
        this.unitReference = unitReference;
    }

    public String getDefaultDisplay () {
        return defaultDisplay;
    }

    public void setDefaultDisplay (String defaultDisplay){
        this.defaultDisplay = defaultDisplay;
    }

    public String getItemReference () {
        return itemReference;
    }

    public void setItemReference (String itemReference) {
        this.itemReference = itemReference;
    }

    public String getLastUpdated (){
        return lastUpdated;
    }

    public void setLastUpdated (String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDateCreated (){
        return dateCreated;
    }

    public void setDateCreated (String dateCreated){
        this.dateCreated = dateCreated;
    }

    public String getBarcode () {
        return barcode;
    }

    public void setBarcode (String barcode){
        this.barcode = barcode;
    }

    public String getQuantity () {
        return quantity;
    }

    public void setQuantity (String quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "ClassPojo [id = "+id+", organization = "+organization+", isDefault = "+isDefault+", unitReference = "+unitReference+", defaultDisplay = "+defaultDisplay+", itemReference = "+itemReference+", lastUpdated = "+lastUpdated+", dateCreated = "+dateCreated+", barcode = "+barcode+", quantity = "+quantity+"]";
    }
}