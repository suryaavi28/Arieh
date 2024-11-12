package com.arieh.tests;

import org.openqa.selenium.By;	
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_AddDispatchPage;
import com.pages.Arieh_UAT_DashboardPage;
import com.pages.Arieh_UAT_DispatchPage;
import com.pages.Arieh_UAT_LoginPage;

public class Arieh_UAT_AddDispatchPageTest extends TestBase_Arieh {
	Arieh_UAT_LoginPage ariehuatloginpage;
	Arieh_UAT_DashboardPage ariehuatdashboardpage;
	Arieh_UAT_DispatchPage ariehuatdispatchpage;
	Arieh_UAT_AddDispatchPage ariehuatadddispatchpage;
	
	
	@BeforeMethod
	public void preBase() {
		setUp();
		ariehuatloginpage = new  Arieh_UAT_LoginPage(driver);
		ariehuatdashboardpage = ariehuatloginpage.validCrdentials();
		ariehuatdispatchpage = ariehuatdashboardpage.clickOnDispatch();
		ariehuatadddispatchpage=ariehuatdispatchpage.clickOnTheAddDispatch();
	} 
	
	
	@Test(invocationCount = 2)
	
	public void testWithAddDispatch() throws InterruptedException {
		ariehuatadddispatchpage.addDispatchReopen();
		String actual = driver.findElement(By.xpath("//th[normalize-space()='Action']")).getText();
		String expected ="Action";
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
		
	}
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
}