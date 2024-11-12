package com.arieh.tests;

import org.openqa.selenium.By	;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_LoginPage;
import com.utils.WaitUtilities;

public class Arieh_UAT_LoginPageTest extends TestBase_Arieh {
    Arieh_UAT_LoginPage ariehloginpage;
    WaitUtilities waitUtils;
    private By loginsuccessfull = By.id("Home");
   

    @BeforeMethod
    public void preBase() {
        setUp();
        ariehloginpage = new Arieh_UAT_LoginPage(driver);
    }

    @Test
    public void testValidCredentials() {
        waitUtils = new WaitUtilities();
        ariehloginpage.validCrdentials();
        boolean Login = waitUtils.waitForInvisibility(driver, loginsuccessfull, 10);
        Assert.assertEquals(Login, true);
    }
    
   

    @Test
    public void testInvalidCredentials() {
        waitUtils = new WaitUtilities();
        ariehloginpage.enterUserName("invalidUsername");
        ariehloginpage.enterPassWord("invalidPassword");
        ariehloginpage.clickSubmit();
        WebElement errorMessage = waitUtils.waitForVisibility(driver, By.className("error-message"), 10);
        Assert.assertNotNull(errorMessage, "Invalid Username/ Password");
    }

    @Test
    public void testEmptyCredentials() {
        waitUtils = new WaitUtilities();
        ariehloginpage.enterUserName("");
        ariehloginpage.enterPassWord("");
       
        Assert.assertEquals(driver.findElement(By.xpath("//button[contains(text(),'Login')]")).isEnabled()	, false);
    }

    @Test
    public void testEmptyUsername() {
        waitUtils = new WaitUtilities();
        ariehloginpage.enterUserName("");
        ariehloginpage.enterPassWord("OctNov@2024#");
               Assert.assertEquals(driver.findElement(By.xpath("//button[contains(text(),'Login')]")).isEnabled()	, false);
    }

    @Test
    public void testEmptyPassword() {
        waitUtils = new WaitUtilities();
        ariehloginpage.enterUserName("avisurya1");
        ariehloginpage.enterPassWord("");
        Assert.assertEquals(driver.findElement(By.xpath("//button[contains(text(),'Login')]")).isEnabled()	, false);
    }

   

 @Test   
public void testWithCopyrightName() {
	String expected="©Arieh";
	String actual =driver.findElement(By.xpath("//label[contains(text(),' ©Arieh ')]")).getText();
	String actualTrim = actual.trim();
	Assert.assertEquals(expected, actualTrim);

}
 
 public void testWithLoginLabel() {
	 String expected="Login to Arieh";
	 String actual = driver.findElement(By.xpath("//label[contains(text(),'Login to Arieh')]")).getText();
	 Assert.assertEquals(expected, actual);
 }
   

    @Test
    public void testSpecialCharactersInCredentials() {
        waitUtils = new WaitUtilities();
        ariehloginpage.enterUserName("avisurya1");
        ariehloginpage.enterPassWord("OctNov@2024#");
        ariehloginpage.clickSubmit();
        boolean Login = waitUtils.waitForInvisibility(driver, loginsuccessfull, 10);
        Assert.assertEquals(Login, true);
    }
    @Test
    public void testWithEmailClick() {
    	boolean actual=ariehloginpage.verifyEmailClick();
    	boolean expected= true;
    	Assert.assertEquals(expected, actual);
    }
    
    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
