/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.client.impl;

import java.util.Map;




import org.apache.log4j.Logger;
import org.mule.modules.valomnia.client.GenericValomniaClient;
import org.mule.modules.valomnia.client.ValomniaClientProvider;
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

import java.util.HashMap;

public class ValomniaClientProviderImpl implements ValomniaClientProvider {

	private Map<Class<?>, GenericValomniaClient<?>> clients;
	  private static final Logger logger=Logger.getLogger(ValomniaClientProviderImpl.class);

	@SuppressWarnings("serial")
	public ValomniaClientProviderImpl(final String baseUrl,
			final String token) {
		try {

			this.clients = new HashMap<Class<?>, GenericValomniaClient<?>>() {
				{

					put(Item.class, new GenericValomniaClientImpl<Item>(baseUrl,token,
							"ItemConnector/",Item.class));
					put(Customer.class,
							new GenericValomniaClientImpl<Customer>(baseUrl,token,
									"CustomerConnector/",Customer.class));
					put(Order.class, new GenericValomniaClientImpl<Order>(
							baseUrl,token, "OrdersConnector/",Order.class));
					put(ItemCategory.class,
							new GenericValomniaClientImpl<ItemCategory>(baseUrl,token,
									"ItemCategoryConnector/",ItemCategory.class));
					put(Attribute.class,
							new GenericValomniaClientImpl<Attribute>(baseUrl,token,
									"AttributeConnector/",Attribute.class));
					put(AttributeValue.class,
							new GenericValomniaClientImpl<AttributeValue>(
									baseUrl,token, "AttributeValueConnector/",AttributeValue.class));
					put(ItemAttribute.class,
							new GenericValomniaClientImpl<ItemAttribute>(baseUrl,token,
									"ItemAttributeConnector/",ItemAttribute.class));
					put(ItemGroup.class,
							new GenericValomniaClientImpl<ItemGroup>(baseUrl,token,
									"ItemGroupConnector/",ItemGroup.class));
					put(ItemGroupAssign.class,
							new GenericValomniaClientImpl<ItemGroupAssign>(
									baseUrl,token, "ItemGroupAssignConnector/",ItemGroupAssign.class));
					put(Unit.class, new GenericValomniaClientImpl<Unit>(baseUrl,token,
							"UnitConnector/",Unit.class));
					put(ItemUnit.class,
							new GenericValomniaClientImpl<ItemUnit>(baseUrl,token,
									"ItemUnitConnector/",ItemUnit.class));
					put(TaxType.class, new GenericValomniaClientImpl<TaxType>(
							baseUrl,token, "TaxTypeConnector/",TaxType.class));
					put(TaxList.class, new GenericValomniaClientImpl<TaxList>(
							baseUrl,token, "TaxListConnector/",TaxList.class));
					put(Tax.class, new GenericValomniaClientImpl<Tax>(baseUrl,token,
							"TaxConnector/",Tax.class));
					put(PriceList.class,
							new GenericValomniaClientImpl<PriceList>(baseUrl,token,
									"PriceListConnector/",PriceList.class));
					put(CustomerCategory.class,
							new GenericValomniaClientImpl<CustomerCategory>(
									baseUrl,token, "CustomerCategoryConnector/",CustomerCategory.class));
					put(CustomerGroup.class,
							new GenericValomniaClientImpl<CustomerGroup>(baseUrl,token,
									"CustomerGroupConnector/",CustomerGroup.class));
					put(Contact.class, new GenericValomniaClientImpl<Contact>(
							baseUrl,token, "ContactConnector/",Contact.class));
					put(CustomerEmployee.class,
							new GenericValomniaClientImpl<CustomerEmployee>(baseUrl,token,
									"customerEmployeeConnector/",CustomerEmployee.class));
					put(CustomerGroupAssign.class,
							new GenericValomniaClientImpl<CustomerGroupAssign>(
									baseUrl,token, "CustomerGroupAssignConnector/",CustomerGroupAssign.class));
					
					put(CustomerCategoryPriceList.class,
							new GenericValomniaClientImpl<CustomerCategoryPriceList>(
									baseUrl,token,
									"CustomerCategoryPriceListConnector/",CustomerCategoryPriceList.class));
					put(CustomerCategoryTaxList.class,
							new GenericValomniaClientImpl<CustomerCategoryTaxList>(
									baseUrl,token, "CustomerCategoryTaxListConnector/",CustomerCategoryTaxList.class));
					put(CustomerPaymentType.class,
							new GenericValomniaClientImpl<CustomerPaymentType>(
									baseUrl,token, "CustomerPaymentTypeConnector/",CustomerPaymentType.class));
					put(CustomerPriceList.class,
							new GenericValomniaClientImpl<CustomerPriceList>(
									baseUrl,token, "CustomerPriceListConnector/",CustomerPriceList.class));
					put(CustomerTaxList.class,
							new GenericValomniaClientImpl<CustomerTaxList>(
									baseUrl,token, "CustomerTaxListConnector/",CustomerTaxList.class));
					put(WareHouse.class,
							new GenericValomniaClientImpl<WareHouse>(baseUrl,token,
									"warehouseConnector/",WareHouse.class));
					put(WareHouseStock.class,
							new GenericValomniaClientImpl<WareHouseStock>(
									baseUrl,token, "warehouseStockConnector/",WareHouseStock.class));
					put(OrderDetail.class,
							new GenericValomniaClientImpl<OrderDetail>(baseUrl,token,
									"OrderDetailConnector/",OrderDetail.class));
					put(OrderPayment.class,
							new GenericValomniaClientImpl<OrderPayment>(baseUrl,token,
									"OrderPaymentConnector/",OrderPayment.class));
					put(EmployeeGroup.class,
							new GenericValomniaClientImpl<EmployeeGroup>(baseUrl,token,
									"EmployeeGroupConnector/",EmployeeGroup.class));
					put(Employee.class,
							new GenericValomniaClientImpl<Employee>(baseUrl,token,
									"EmployeeConnector/",Employee.class));
					put(User.class, new GenericValomniaClientImpl<User>(baseUrl,token,
							"UserConnector/",User.class));
					put(Authority.class,
							new GenericValomniaClientImpl<Authority>(baseUrl,token,
									"AuthorityConnector/",Authority.class));
					put(UserAuthority.class,
							new GenericValomniaClientImpl<UserAuthority>(baseUrl,token,
									"UserAuthorityConnector/",UserAuthority.class));
					put(Loading.class, new GenericValomniaClientImpl<Loading>(
							baseUrl,token, "LoadingConnector/",Loading.class));
					put(LoadingDetails.class,
							new GenericValomniaClientImpl<LoadingDetails>(
									baseUrl,token, "LoadingDetailsConnector/",LoadingDetails.class));
					put(Price.class, new GenericValomniaClientImpl<Price>(
							baseUrl,token, "PriceConnector/",Price.class));

				}
			};

		} catch (Exception e) {

			
				logger.error("exception",e);
		
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> GenericValomniaClient<T> getClient(final Class<T> type) {
		return (GenericValomniaClient<T>) this.clients.get(type);
	}

}
