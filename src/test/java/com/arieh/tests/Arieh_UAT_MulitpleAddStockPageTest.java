package com.arieh.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_DashboardPage;
import com.pages.Arieh_UAT_DispatchPage;
import com.pages.Arieh_UAT_LoginPage;
import com.pages.Arieh_UAT_MultipleAddStockPage;

public class Arieh_UAT_MulitpleAddStockPageTest extends TestBase_Arieh {
 Arieh_UAT_MultipleAddStockPage ariehuatmultipleaddstockpage;
 Arieh_UAT_LoginPage ariehuatloginpage;
 Arieh_UAT_DashboardPage ariehuatdashboardpage;
 Arieh_UAT_DispatchPage ariehuatdispatchpage;

 
 @BeforeMethod
 public void preBase() {
		setUp();
		ariehuatloginpage = new Arieh_UAT_LoginPage(driver);
		ariehuatdashboardpage = ariehuatloginpage.validCrdentials();
		ariehuatdispatchpage = ariehuatdashboardpage.clickOnDispatch();
		ariehuatmultipleaddstockpage=ariehuatdispatchpage.clickOnTheAddStocks();
	}
	
	//@Test(invocationCount = 1)
	public void testWithAddMulitpleStock() throws InterruptedException {
		ariehuatmultipleaddstockpage.enterMultipleStock();
	}
	
	@Test
	public void testWithUploadExcelForAddStock() throws Exception {
		ariehuatmultipleaddstockpage.AddStockExcel();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
	
}
