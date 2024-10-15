package com.arieh.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_LoginPage;
import com.utils.WaitUtilities;

public class Arieh_UAT_LoginPageTest extends TestBase_Arieh{
Arieh_UAT_LoginPage ariehloginpage;
WaitUtilities waitUtils;
private By loginsuccessfull= By.id("Home");
	@BeforeMethod
	public void preBase() {
		setUp();
		ariehloginpage = new Arieh_UAT_LoginPage(driver);
		
	}
	@Test
	public void testValidCredentials(){
		waitUtils = new WaitUtilities();
		ariehloginpage.validCrdentials();
		
	boolean Login =waitUtils.waitForInvisibility(driver, loginsuccessfull, 10);
	Assert.assertEquals(Login, true);}
		
	
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
}
