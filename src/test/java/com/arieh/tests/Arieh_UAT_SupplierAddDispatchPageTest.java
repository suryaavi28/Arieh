package com.arieh.tests;

import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_LoginPage;
import com.pages.Arieh_UAT_SupplierAddDispatchPage;
import com.pages.Arieh_UAT_SupplierDashboardPage;
import com.pages.Arieh_UAT_SupplierStockPage;

public class Arieh_UAT_SupplierAddDispatchPageTest extends TestBase_Arieh{
Arieh_UAT_LoginPage ariehuatloginpage;
Arieh_UAT_SupplierDashboardPage ariehuatsupplieruatdashboardpage ;
Arieh_UAT_SupplierStockPage ariehuatsupplierstockpage;
Arieh_UAT_SupplierAddDispatchPage ariehuatsupplieradddispatchpage;


@BeforeMethod
public void preBase() throws SQLException, InterruptedException {
	setUp();
	ariehuatloginpage = new Arieh_UAT_LoginPage(driver);
	ariehuatsupplieruatdashboardpage = ariehuatloginpage.loginToSupplierDashBoard();
	ariehuatsupplierstockpage=ariehuatsupplieruatdashboardpage.clickOnDispatch();
	ariehuatsupplieradddispatchpage = ariehuatsupplierstockpage.clickOnDispatchTab();
	
}

@Test(dependsOnMethods = {"com.arieh.tests.Arieh_UAT_AddStockPageTest.testAddStockCode"})
public void testWithAddDispaptch() throws InterruptedException {
	ariehuatsupplieradddispatchpage.clickOnTheAddDispatch();
}

@AfterMethod
public void closeTest() {
	tearDown();
}
	
}
