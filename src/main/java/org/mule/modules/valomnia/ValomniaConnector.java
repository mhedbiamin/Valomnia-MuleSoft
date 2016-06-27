/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia;


import java.util.List;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Payload;
import org.mule.modules.valomnia.core.ConnectorConfig;
import org.mule.modules.valomnia.entities.Attribute;
import org.mule.modules.valomnia.entities.AttributeValue;
import org.mule.modules.valomnia.entities.Authority;
import org.mule.modules.valomnia.entities.Contact;
import org.mule.modules.valomnia.entities.Customer;
import org.mule.modules.valomnia.entities.CustomerCategory;
import org.mule.modules.valomnia.entities.CustomerCategoryPriceList;
import org.mule.modules.valomnia.entities.CustomerCategoryTaxList;
import org.mule.modules.valomnia.entities.CustomerEmployee;
import org.mule.modules.valomnia.entities.CustomerGroup;
import org.mule.modules.valomnia.entities.CustomerGroupAssign;
import org.mule.modules.valomnia.entities.CustomerPaymentType;
import org.mule.modules.valomnia.entities.CustomerPriceList;
import org.mule.modules.valomnia.entities.CustomerTaxList;
import org.mule.modules.valomnia.entities.Employee;
import org.mule.modules.valomnia.entities.EmployeeGroup;
import org.mule.modules.valomnia.entities.Item;
import org.mule.modules.valomnia.entities.ItemAttribute;
import org.mule.modules.valomnia.entities.ItemCategory;
import org.mule.modules.valomnia.entities.ItemGroup;
import org.mule.modules.valomnia.entities.ItemGroupAssign;
import org.mule.modules.valomnia.entities.ItemUnit;
import org.mule.modules.valomnia.entities.Loading;
import org.mule.modules.valomnia.entities.LoadingDetails;
import org.mule.modules.valomnia.entities.Order;
import org.mule.modules.valomnia.entities.OrderDetail;
import org.mule.modules.valomnia.entities.OrderPayment;
import org.mule.modules.valomnia.entities.Price;
import org.mule.modules.valomnia.entities.PriceList;
import org.mule.modules.valomnia.entities.Tax;
import org.mule.modules.valomnia.entities.TaxList;
import org.mule.modules.valomnia.entities.TaxType;
import org.mule.modules.valomnia.entities.Unit;
import org.mule.modules.valomnia.entities.User;
import org.mule.modules.valomnia.entities.UserAuthority;
import org.mule.modules.valomnia.entities.WareHouse;
import org.mule.modules.valomnia.entities.WareHouseStock;



/**
 * Mule Connector for Valomnia.
 * <p/>
 * <p>
 *  Valomnia is  a solution laverages Mobility and Cloud technologies to streamline suppliers and manufacturers Sales and Distribution processes.
 * </p>
 * <p>
 * Valomnia is made to improve operational efficiency in Direct Store Delivery (DSD) process, providing business oriented, simple and ergonomic apps for its users.

 * 
 * </p>
 * 
 * @author MuleSoft, inc.
 */
@Connector(name = "valomnia", friendlyName = "Valomnia", minMuleVersion = "3.7.3")
public class ValomniaConnector {

    @Config
    ConnectorConfig config;

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

    /**
     * find all Items for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-items}
     *
     * @return List of all the Items
     * 
     */

    @Processor
    public List<Item> findItems() {
        return this.config.getClientProvider()
                .getClient(Item.class)
                .getAll();
    }

    /**
     * find all Customers for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers}
     *
     * @return a List of all the Customers
     * 
     */

    @Processor
    public List<Customer> findCustomers()  {

        return this.config.getClientProvider()
                .getClient(Customer.class)
                .getAll();

    }
    
    /**
     * find all Attributs for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-attributs}
     *
     * @return a List of all the Attributs
     *  
     */

    
  
    @Processor
    public List<Attribute> findAttributs()  {

        return this.config.getClientProvider()
                .getClient(Attribute.class)
                .getAll();

    }
    
    
    /**
     * find all Items Attribute for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-items-attribute}
     *
     * @return a List of all the  Items Attribute 
    
     */
    
    @Processor
    public List<ItemAttribute> findItemsAttribute() {

        return this.config.getClientProvider()
                .getClient(ItemAttribute.class)
                .getAll();

    }
    
    /**
     * find all Items Orders for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-orders}
     *
     * @return a List of all the Orders
    
     */

    @Processor
    public List<Order> findOrders()  {
        return this.config.getClientProvider()
                .getClient(Order.class)
                .getAll();
    }
    
    /**
     * find all Items Group for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-items-group}
     *
     * @return a List of all the Items  Group
     
     */


    @Processor
    public List<ItemGroup> findItemsGroup()  {
        return this.config.getClientProvider()
                .getClient(ItemGroup.class)
                .getAll();
    }

    /**
     * find all Items Group Assign for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-items-group-assign}
     *
     * @return a List of all the Items Group Assign
    
     */
    
    
    @Processor
    public List<ItemGroupAssign> findItemsGroupAssign()    {
        return this.config.getClientProvider()
                .getClient(ItemGroupAssign.class)
                .getAll();
    }
    
    /**
     * find all Units for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-units}
     *
     * @return a List of all the Units
     
     */

    @Processor
    public List<Unit> findUnits()  {
        return this.config.getClientProvider()
                .getClient(Unit.class)
                .getAll();
    }
    /**
     * find all Item Units for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-item-units}
     *
     * @return a List of all the Item Units
     
     */

    @Processor
    public List<ItemUnit> findItemUnits()  {
        return this.config.getClientProvider()
                .getClient(ItemUnit.class)
                .getAll();
    }
    
    /**
     * find all Tax Type for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-tax-types}
     *
     * @return a List of all the TaxType
     
     */

    @Processor
    public List<TaxType> findTaxTypes() {
        return this.config.getClientProvider()
                .getClient(TaxType.class)
                .getAll();
    }
    
    /**
     * find all TaxLists for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-tax-lists}
     *
     * @return a List of all the TaxList
     
     */

    @Processor
    public List<TaxList> findTaxLists()  {
        return this.config.getClientProvider()
                .getClient(TaxList.class)
                .getAll();
    }
    /**
     * find all Taxs for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-taxs}
     *
     * @return a List of all the Taxs
    
     */

    @Processor
    public List<Tax> findTaxs()  {
        return this.config.getClientProvider()
                .getClient(Tax.class)
                .getAll();
    }

    
    /**
     * find all Price Lists for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-price-lists}
     *
     * @return a List of all the Price Lists
      
     */
    @Processor
    public List<PriceList> findPriceLists()    {
        return this.config.getClientProvider()
                .getClient(PriceList.class)
                .getAll();
    }
    
    
    /**
     * find all Prices for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-prices}
     *
     * @return a List of all the Prices
     * 
     */

    @Processor
    public List<Price> findPrices()    {
        return this.config.getClientProvider()
                .getClient(Price.class)
                .getAll();
    }
    
    
    /**
     * find all Orders Detail for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-orders-detail}
     *
     * @return a List of all the Orders Detail
      
     */
    
    @Processor
    public List<OrderDetail> findOrdersDetail()    {
        return this.config.getClientProvider()
                .getClient(OrderDetail.class)
                .getAll();
    }

    /**
     * find all Customers Category for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-category}
     *
     * @return a List of all the Customers Category
      
     */
    @Processor
    public List<CustomerCategory> findCustomersCategory()    {
        return this.config.getClientProvider()
                .getClient(CustomerCategory.class)
                .getAll();
    }

    
    /**
     * find all Contacts  for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-contacts}
     *
     * @return a List of all the Contacts
       
     */
    @Processor
    public List<Contact> findContacts()    {
        return this.config.getClientProvider()
                .getClient(Contact.class)
                .getAll();
    }
    
    
    /**
     * find all Customers Group for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-group}
     *
     * @return a List of all the Customers Group
       
     */
    @Processor
    public List<CustomerGroup> findCustomersGroup()    {
        return this.config.getClientProvider()
                .getClient(CustomerGroup.class)
                .getAll();
    }
    
    /**
     * find all Customers Group Assign for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-group-assign}
     *
     * @return a List of all the Customers Group Assign
       
     */

    @Processor
    public List<CustomerGroupAssign> findCustomersGroupAssign()    {
        return this.config.getClientProvider()
                .getClient(CustomerGroupAssign.class)
                .getAll();
    }

    
    

    
    
    
    
    /**
     * find all Customers Category Price List for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-category-price-list}
     *
     * @return a List of all the Customers Category Price List
       
     */

    @Processor
    public List<CustomerCategoryPriceList> findCustomersCategoryPriceList() {
        return this.config.getClientProvider()
                .getClient(CustomerCategoryPriceList.class)
                .getAll();
    }
    
    /**
     * find all Customers Category  Tax List for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-category-tax-list}
     *
     * @return a List of all the Customers Category Tax List
       
     */

    @Processor
    public List<CustomerCategoryTaxList> findCustomersCategoryTaxList() {
        return this.config.getClientProvider()
                .getClient(CustomerCategoryTaxList.class)
                .getAll();
    }
    
    /**
     * find all Customers Payment Type for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-payment-type}
     *
     * @return a List of all the Customers  Payment Type
      
     */

    @Processor
    public List<CustomerPaymentType> findCustomersPaymentType()    {
        return this.config.getClientProvider()
                .getClient(CustomerPaymentType.class)
                .getAll();
    }
    
    /**
     * find all Customers Price List  for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-price-list}
     *
     * @return a List of all the Customers Price List
      
     */

    @Processor
    public List<CustomerPriceList> findCustomersPriceList()    {
        return this.config.getClientProvider()
                .getClient(CustomerPriceList.class)
                .getAll();
    }
    
    /**
     * find all Customers Tax list for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-tax-list}
     *
     * @return a List of all the Customers Tax List
       
     */

    @Processor
    public List<CustomerTaxList> findCustomersTaxList()    {
        return this.config.getClientProvider()
                .getClient(CustomerTaxList.class)
                .getAll();
    }
    
    /**
     * find all WareHouses for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-ware-houses}
     *
     * @return a List of all the WareHouses
      
     */

    @Processor
    public List<WareHouse> findWareHouses()    {
        return this.config.getClientProvider()
                .getClient(WareHouse.class)
                .getAll();
    }
    
    /**
     * find all WareHouses Stocks for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-ware-house-stock}
     *
     * @return a List of all the WareHouses Stocks
       
     */

    @Processor
    public List<WareHouseStock> findWareHouseStocks()    {
        return this.config.getClientProvider()
                .getClient(WareHouseStock.class)
                .getAll();
    }

    
   
    /**
     * find all Employee Groups  for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-employee-groups}
     *
     * @return a List of all the Employee Group
      
     */

    @Processor
    public List<EmployeeGroup> findEmployeeGroups()    {
        return this.config.getClientProvider()
                .getClient(EmployeeGroup.class)
                .getAll();
    }
    /**
     * find all Employees  for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-employees}
     *
     * @return a List of all the Employee
     
     */

    @Processor
    public List<Employee> findEmployees()    {
        return this.config.getClientProvider()
                .getClient(Employee.class)
                .getAll();
    }
    /**
     * find all Users for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-users}
     *
     * @return a List of all the Users
       
     */

    @Processor
    public List<User> findUsers()    {
        return this.config.getClientProvider()
                .getClient(User.class)
                .getAll();
    }
    
    /**
     * find all Authority for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-authority}
     *
     * @return a List of all the  Authority 
      
     */

    @Processor
    public List<Authority> findAuthority()    {
        return this.config.getClientProvider()
                .getClient(Authority.class)
                .getAll();
    }
    
    /**
     * find all  User Authority for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-users-authority}
     *
     * @return a List of all the   User Authority 
      
     */

    @Processor
    public List<UserAuthority> findUsersAuthority()    {
        return this.config.getClientProvider()
                .getClient(UserAuthority.class)
                .getAll();
    }
    
    /**
     * find all Loadings for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-loadings}
     *
     * @return a List of all the  Loadings 
       
     */

    @Processor
    public List<Loading> findLoadings()    {
        return this.config.getClientProvider()
                .getClient(Loading.class)
                .getAll();
    }
    
    /**
     * find all Attributes Value for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-attributes-value}
     *
     * @return a List of all the  Attributes Value
      
     */
    
    
    
    @Processor
    public List<AttributeValue> findAttributesValue()    {
        return this.config.getClientProvider()
                .getClient(AttributeValue.class)
                .getAll();
    }
    
    /**
     * find all Loading Details for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-loading-details}
     *
     * @return a List of all the  Loading Details
       
     */

    @Processor
    public List<LoadingDetails> findLoadingDetails()    {
        return this.config.getClientProvider()
                .getClient(LoadingDetails.class)
                .getAll();
    }
    
    /**
     * find all Customers Employee for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-customers-employee}
     *
     * @return a List of all the  Loadings 
       
     */

    @Processor
    public List<CustomerEmployee> findCustomersEmployee()    {
        return this.config.getClientProvider()
                .getClient(CustomerEmployee.class)
                .getAll();
    }
    
    /**
     * find all Orders Payment  for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-orders-payment}
     *
     * @return a List of all the  Orders Payment
      
     */
    
    @Processor
    public List<OrderPayment> findOrdersPayment()    {
        return this.config.getClientProvider()
                .getClient(OrderPayment.class)
                .getAll();
    }

    /**
     * find all Items Category for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:find-items-category}
     *
     * @return a List of all the  Items Category 
     
     */
    
    
    @Processor
    public List<ItemCategory> findItemsCategory()    {
        return this.config.getClientProvider()
                .getClient(ItemCategory.class)
                .getAll();
    }

    /**
     * merge   an Item entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeItem(@Payload Item obj) {
        return this.config.getClientProvider()
                .getClient(Item.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerCategoryPriceList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-category-price-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    @Processor
    public String mergeCustomerCategoryPriceList(@Payload CustomerCategoryPriceList obj) {
        return this.config.getClientProvider()
                .getClient(CustomerCategoryPriceList.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerCategory entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-category}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    
    @Processor
    public String mergeCustomerCategory(@Payload CustomerCategory obj) {
        return this.config.getClientProvider()
                .getClient(CustomerCategory.class)
                .merge(obj);
    }
    
    /**
     * merge   an PriceList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-price-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    
    @Processor
    public String mergePriceList(@Payload PriceList obj) {
        return this.config.getClientProvider()
                .getClient(PriceList.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerCategoryTaxList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-category-tax-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
   
    
    @Processor
    public String mergeCustomerCategoryTaxList(@Payload CustomerCategoryTaxList obj) {
        return this.config.getClientProvider()
                .getClient(CustomerCategoryTaxList.class)
                .merge(obj);
    }

    /**
     * merge   an ItemCategory entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item-category}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
   

    @Processor
    public String mergeItemCategory(@Payload ItemCategory obj) {
        return this.config.getClientProvider()
                .getClient(ItemCategory.class)
                .merge(obj);
    }

    
    /**
     * merge   an TaxList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-tax-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    @Processor
    public String mergeTaxList(@Payload TaxList obj) {
        return this.config.getClientProvider()
                .getClient(TaxList.class)
                .merge(obj);
    }
    
    /**
     * merge   an Contact entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-contact}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
   

    @Processor
    public String mergeContact(@Payload Contact obj) {
        return this.config.getClientProvider()
                .getClient(Contact.class)
                .merge(obj);
    }
    
    /**
     * merge   an Customer entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeCustomer(@Payload Customer obj) {
        return this.config.getClientProvider()
                .getClient(Customer.class)
                .merge(obj);
    }
    /**
     * merge   an ItemAttribute entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item-attribute}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeItemAttribute(@Payload ItemAttribute obj) {
        return this.config.getClientProvider()
                .getClient(ItemAttribute.class)
                .merge(obj);
    }
    /**
     * merge   an Attribute entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-attribute}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    @Processor
    public String mergeAttribute(@Payload Attribute obj) {
        return this.config.getClientProvider()
                .getClient(Attribute.class)
                .merge(obj);
    }
    
    /**
     * merge   an Employee entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-employee}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeEmployee(@Payload Employee obj) {
        return this.config.getClientProvider()
                .getClient(Employee.class)
                .merge(obj);
    }

    
    /**
     * merge   an CustomerGroup entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-group}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeCustomerGroup(@Payload CustomerGroup obj) {
        return this.config.getClientProvider()
                .getClient(CustomerGroup.class)
                .merge(obj);
    }
    
    
    /**
     * merge   an CustomerEmployee entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-employee}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeCustomerEmployee(@Payload CustomerEmployee obj) {
        return this.config.getClientProvider()
                .getClient(CustomerEmployee.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerGroupAssign entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-group-assign}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeCustomerGroupAssign(@Payload CustomerGroupAssign obj) {
        return this.config.getClientProvider()
                .getClient(CustomerGroupAssign.class)
                .merge(obj);
    }

    
    
    
    /**
     * merge   an UserAuthority entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-user-authority}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    
    @Processor
    public String mergeUserAuthority(@Payload UserAuthority obj) {
        return this.config.getClientProvider()
                .getClient(UserAuthority.class)
                .merge(obj);
    }
    
    /**
     * merge   an Authority entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-authority}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeAuthority(@Payload Authority obj) {
        return this.config.getClientProvider()
                .getClient(Authority.class)
                .merge(obj);
    }
    
    
    
    /**
     * merge   an CustomerPaymentType entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-payment-type}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeCustomerPaymentType(@Payload CustomerPaymentType obj) {
        return this.config.getClientProvider()
                .getClient(CustomerPaymentType.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerPriceList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-price-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeCustomerPriceList(@Payload CustomerPriceList obj) {
        return this.config.getClientProvider()
                .getClient(CustomerPriceList.class)
                .merge(obj);
    }
    
    /**
     * merge   an CustomerTaxList entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-customer-tax-list}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeCustomerTaxList(@Payload CustomerTaxList obj) {
        return this.config.getClientProvider()
                .getClient(CustomerTaxList.class)
                .merge(obj);
    }

    
    /**
     * merge   an EmployeeGroup entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-employee-group}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeEmployeeGroup(@Payload EmployeeGroup obj) {
        return this.config.getClientProvider()
                .getClient(EmployeeGroup.class)
                .merge(obj);
    }
    /**
     * merge   an Tax entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-tax}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeTax(@Payload Tax obj) {
        return this.config.getClientProvider()
                .getClient(Tax.class)
                .merge(obj);
    }
    
    /**
     * merge   an ItemGroup entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item-group}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeItemGroup(@Payload ItemGroup obj) {
        return this.config.getClientProvider()
                .getClient(ItemGroup.class)
                .merge(obj);
    }
    
    /**
     * merge   an ItemGroupAssign entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item-group-assign}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeItemGroupAssign(@Payload ItemGroupAssign obj) {
        return this.config.getClientProvider()
                .getClient(ItemGroupAssign.class)
                .merge(obj);
    }
    
    
    /**
     * merge   an AttributeValue entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-attribute-value}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeAttributeValue(@Payload  AttributeValue obj) {
        return this.config.getClientProvider()
                .getClient(AttributeValue.class)
                .merge(obj);
    }
    
    /**
     * merge   an ItemUnit entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-item-unit}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeItemUnit(@Payload ItemUnit obj) {
        return this.config.getClientProvider()
                .getClient(ItemUnit.class)
                .merge(obj);
    }

    /**
     * merge   an Loading entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-loading}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeLoading(@Payload Loading obj) {
        return this.config.getClientProvider()
                .getClient(Loading.class)
                .merge(obj);
    }

    
    /**
     * merge   an LoadingDetails entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-loading-details}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeLoadingDetails(@Payload LoadingDetails obj) {
        return this.config.getClientProvider()
                .getClient(LoadingDetails.class)
                .merge(obj);
    }

    
    /**
     * merge   an OrderDetail entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-order-detail}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeOrderDetail(@Payload OrderDetail obj) {
        return this.config.getClientProvider()
                .getClient(OrderDetail.class)
                .merge(obj);
    }
    /**
     * merge   an OrderPayment entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-order-payment}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeOrderPayment(@Payload OrderPayment obj) {
        return this.config.getClientProvider()
                .getClient(OrderPayment.class)
                .merge(obj);
    }
    
    /**
     * merge   an Price entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-price}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergePrice(@Payload Price obj) {
        return this.config.getClientProvider()
                .getClient(Price.class)
                .merge(obj);
    }
    /**
     * merge   an Order entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-order}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeOrder(@Payload Object obj) {
        return this.config.getClientProvider()
                .getClient(Order.class)
                .merge(obj);
    }
    
    /**
     * merge   an TaxType entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-tax-type}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeTaxType(@Payload TaxType obj) {
        return this.config.getClientProvider()
                .getClient(TaxType.class)
                .merge(obj);
    }

    
    /**
     * merge   an Unit entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-unit}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeUnit(@Payload Unit obj) {
        return this.config.getClientProvider()
                .getClient(Unit.class)
                .merge(obj);
    }
    
    /**
     * merge   an User entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-user}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */

    @Processor
    public String mergeUser(@Payload Object obj) {
        return this.config.getClientProvider()
                .getClient(User.class)
                .merge(obj);
    }

    
    /**
     * merge   an WareHouse entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-ware-house}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeWareHouse(@Payload Object obj) {
        return this.config.getClientProvider()
                .getClient(WareHouse.class)
                .merge(obj);
    }

    
    /**
     * merge  an WareHouseStock entity for the connected account
     *
     * { @sample.xml /valomnia-connector/doc/valomnia-connector.xml.sample valomnia:merge-ware-house-stock}
     * 
     * @param obj
     *            the input object merged  d
     * @return response String for Valomnia API
     */
    @Processor
    public String mergeWareHouseStock(@Payload Object obj) {
        return this.config.getClientProvider()
                .getClient(WareHouseStock.class)
                .merge(obj);
    }

}
