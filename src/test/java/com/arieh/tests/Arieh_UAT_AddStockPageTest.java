package com.arieh.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_AddStockPage;
import com.pages.Arieh_UAT_DashboardPage;
import com.pages.Arieh_UAT_DispatchPage;
import com.pages.Arieh_UAT_LoginPage;

public class Arieh_UAT_AddStockPageTest extends TestBase_Arieh{
	Arieh_UAT_LoginPage ariehuatloginpage;
	Arieh_UAT_AddStockPage ariehuataddstockpage;
	Arieh_UAT_DispatchPage ariehuatdispatchpage;
	Arieh_UAT_DashboardPage ariehuatdashboardpage;
	
	@BeforeMethod
	public void preBase () {
		setUp();
		ariehuatloginpage = new Arieh_UAT_LoginPage(driver);
		ariehuatdashboardpage = ariehuatloginpage.validCrdentials();
		ariehuatdispatchpage = ariehuatdashboardpage.clickOnDispatch();
		ariehuataddstockpage=ariehuatdispatchpage.clickOnAddStock();
		
	}
	
	@Test(invocationCount = 10)
	public void testAddStock()  {
		ariehuataddstockpage.AddStockAndSubmitOne();
		
		
	}
	@Test(invocationCount = 10)
	public void testAddStock2()  {
		ariehuataddstockpage.AddStockAndSubmitTwo();
		
	}
	@Test(invocationCount = 10)
	public void testAddStock3()  {
		ariehuataddstockpage.AddStockAndSubmitThree();
		
	}
	@Test(invocationCount = 10)
	public void testAddStock4()  {
		ariehuataddstockpage.AddStockAndSubmitFour();
		
	}
	@AfterMethod
	public void tearDownTest() throws InterruptedException {
		//Thread.sleep(2000);
		tearDown();
	}
}
