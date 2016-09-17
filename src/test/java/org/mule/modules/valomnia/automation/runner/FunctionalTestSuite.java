/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.valomnia.automation.runner;

import org.junit.AfterClass;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;
import org.mule.modules.valomnia.automation.functional.EntitiesTestCases;
import org.mule.modules.valomnia.automation.functional.FindAttributsTestCases;
import org.mule.modules.valomnia.automation.functional.FindAuthorityTestCases;
import org.mule.modules.valomnia.automation.functional.FindContactsTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerCategroryTaxListTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerEmployeeTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerGroupAssignTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerPaymentTypeTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerPriceListTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomersCategoryTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerCategroryPriceListTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomerTaxListTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomersGroupTestCases;
import org.mule.modules.valomnia.automation.functional.FindCustomersTestCases;
import org.mule.modules.valomnia.automation.functional.FindEmployeeGroupsTestCases;
import org.mule.modules.valomnia.automation.functional.FindEmployeesTestCases;
import org.mule.modules.valomnia.automation.functional.FindItemGroupAssignTestCases;
import org.mule.modules.valomnia.automation.functional.FindItemUnitsTestCases;
import org.mule.modules.valomnia.automation.functional.FindItemsCategoryTestCases;
import org.mule.modules.valomnia.automation.functional.FindItemsGroupTestCases;
import org.mule.modules.valomnia.automation.functional.FindItemsTestCases;
import org.mule.modules.valomnia.automation.functional.FindLoadingDetailsTestCases;
import org.mule.modules.valomnia.automation.functional.FindLoadingsTestCases;
import org.mule.modules.valomnia.automation.functional.FindOrdersDetailsTestCases;
import org.mule.modules.valomnia.automation.functional.FindOrdersPaymentTestCases;
import org.mule.modules.valomnia.automation.functional.FindOrdersTestCases;
import org.mule.modules.valomnia.automation.functional.FindPriceListsTestCases;
import org.mule.modules.valomnia.automation.functional.FindPricesTestCases;
import org.mule.modules.valomnia.automation.functional.FindTaxListsTestCases;
import org.mule.modules.valomnia.automation.functional.FindTaxTypesTestCases;
import org.mule.modules.valomnia.automation.functional.FindUnitsTestCases;
import org.mule.modules.valomnia.automation.functional.FindUsersAuthorityTestCases;
import org.mule.modules.valomnia.automation.functional.FindUsersTestCases;
import org.mule.modules.valomnia.automation.functional.FindWareHouseStocksTestCases;
import org.mule.modules.valomnia.automation.functional.FindWareHousesTestCases;
import org.mule.modules.valomnia.automation.functional.MergeContactTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerCategoryTaxListTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerGroupAssignTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerGroupTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerTaxListTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemCategoryTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemGroupAssignTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemGroupTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemTestCases;
import org.mule.modules.valomnia.automation.functional.MergeTaxTestCases;
import org.mule.modules.valomnia.automation.functional.MergeUnitTestCases;
import org.mule.modules.valomnia.automation.functional.MergeUserTestCases;
import org.mule.modules.valomnia.automation.functional.MergeTaxListTestCases;
import org.mule.modules.valomnia.automation.functional.MergeEmployeeTestCases;
import org.mule.modules.valomnia.automation.functional.MergePriceListTestCases;
import org.mule.modules.valomnia.automation.functional.MergePriceTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerCategoryTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerPaymentTypeTestCases;
import org.mule.modules.valomnia.automation.functional.MergeWareHouseTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemUnitTestCases;
import org.mule.modules.valomnia.automation.functional.MergeAuthorityTestCases;
import org.mule.modules.valomnia.automation.functional.MergeUserAuthorityTestCases;
import org.mule.modules.valomnia.automation.functional.MergeLoadingTestCases;
import org.mule.modules.valomnia.automation.functional.MergeLoadingDetailsTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerEmployeeTestCases;
import org.mule.modules.valomnia.automation.functional.MergeTaxTypeTestCases;
import org.mule.modules.valomnia.automation.functional.FindTaxsTestCases;
import org.mule.modules.valomnia.automation.functional.MergeAttributeTestCases;
import org.mule.modules.valomnia.automation.functional.MergeAttributeValueTestCases;
import org.mule.modules.valomnia.automation.functional.MergeEmployeeGroupTestCases;
import org.mule.modules.valomnia.automation.functional.MergeOrderTestCases;
import org.mule.modules.valomnia.automation.functional.MergeOrderDetailTestCases;
import org.mule.modules.valomnia.automation.functional.MergeOrderPaymentTestCases;
import org.mule.modules.valomnia.automation.functional.MergeWareHouseStockTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerCategoryPriceListTestCases;
import org.mule.modules.valomnia.automation.functional.MergeCustomerPriceListTestCases;
import org.mule.modules.valomnia.automation.functional.FindAttributesValueTestCases;
import org.mule.modules.valomnia.automation.functional.MergeItemAttributeTestCases;


@RunWith(Suite.class)
@SuiteClasses({
	EntitiesTestCases.class,
	
	FindAttributesValueTestCases.class, FindItemsTestCases.class,
		FindItemsGroupTestCases.class, FindAttributsTestCases.class,
		FindUsersTestCases.class, FindAuthorityTestCases.class,
		FindTaxsTestCases.class, FindContactsTestCases.class,
		FindCustomersCategoryTestCases.class,
		FindCustomerCategroryPriceListTestCases.class,
		FindCustomerCategroryTaxListTestCases.class,
		FindCustomerPaymentTypeTestCases.class,
		FindCustomerPriceListTestCases.class,MergeCustomerTaxListTestCases.class,
		MergeTaxTestCases.class,
		FindCustomersGroupTestCases.class, FindCustomersTestCases.class,
		FindItemsCategoryTestCases.class, FindUnitsTestCases.class,
		FindLoadingDetailsTestCases.class, FindLoadingsTestCases.class,
		FindOrdersDetailsTestCases.class, FindOrdersPaymentTestCases.class,
		FindOrdersTestCases.class, FindPriceListsTestCases.class,
		FindPricesTestCases.class, FindTaxListsTestCases.class,
		FindTaxTypesTestCases.class, FindEmployeeGroupsTestCases.class,
		FindEmployeesTestCases.class, FindItemGroupAssignTestCases.class,
		FindItemUnitsTestCases.class, FindCustomerTaxListTestCases.class,
		FindUsersAuthorityTestCases.class, FindUsersTestCases.class,
		FindWareHousesTestCases.class, FindWareHouseStocksTestCases.class,
		FindCustomerEmployeeTestCases.class,
		FindCustomerGroupAssignTestCases.class, MergeContactTestCases.class,
		MergeItemGroupTestCases.class, MergeEmployeeTestCases.class,
		MergeItemGroupAssignTestCases.class, MergeItemCategoryTestCases.class,
		MergeItemTestCases.class, MergeCustomerTestCases.class,
		MergeCustomerGroupAssignTestCases.class,
		MergeCustomerGroupTestCases.class, MergeUnitTestCases.class,
		MergeUserTestCases.class, MergeTaxListTestCases.class,
		MergePriceListTestCases.class, MergePriceTestCases.class,
		MergeCustomerCategoryTestCases.class,MergeCustomerCategoryTaxListTestCases.class,
		MergeCustomerPaymentTypeTestCases.class, MergeWareHouseTestCases.class,
		MergeItemUnitTestCases.class, MergeAuthorityTestCases.class,
		MergeUserAuthorityTestCases.class, MergeLoadingTestCases.class,
		MergeLoadingDetailsTestCases.class,
		MergeCustomerEmployeeTestCases.class, MergeTaxTypeTestCases.class,
		MergeEmployeeGroupTestCases.class, MergeOrderTestCases.class,
		MergeOrderDetailTestCases.class, MergeOrderPaymentTestCases.class,
		MergeWareHouseStockTestCases.class,
		MergeCustomerCategoryPriceListTestCases.class,
		MergeCustomerPriceListTestCases.class, MergeAttributeTestCases.class,
		MergeAttributeValueTestCases.class, MergeItemAttributeTestCases.class
		 })
public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {
		ConnectorTestContext.initialize(ValomniaConnector.class);
	}

	@AfterClass
	public static void shutdownSuite() {
		ConnectorTestContext.shutDown();
	}

}