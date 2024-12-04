package com.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_LoginPage {

	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Arieh_UAT_ResidualPage ariehuatresidualpage;
	
	public Arieh_UAT_LoginPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities();
		configUtils.readCOnfig();
		ariehuatresidualpage = new Arieh_UAT_ResidualPage(driver);
		
	}
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By submitbtn = By.xpath("//button[@type='submit']");
	private By mail = By.xpath("//div[@class='help-email']");
	private By supplierclick= By.xpath("//div[contains(text(),'Supplier')]");
	private By emailmob = By.xpath("//input[@placeholder='Enter your Email/Mobile Number']");
	private By loginbtn = By.xpath("//button[contains(text(),'Send OTP')]");
	private By otpent= By.id("otp");
	private By logintosupplier = By.xpath("//button[contains(text(),'Login')]");
	
	public void enterUserName(String un) {
		WebElement enterun = waitUtils.waitForVisibility(driver, username, 10);
		enterun.sendKeys(un);
	
	}
	
	public void enterPassWord(String pw) {
		WebElement enterpw = waitUtils.waitForVisibility(driver, password, 10);
		enterpw.sendKeys(pw);
	
	}
	
	public void clickOnSupplier() {
		WebElement sup = waitUtils.elementToBeClickable(driver, supplierclick, 10);
		sup.click();		
	}
	
	public void enterMobileNumber() {
		WebElement emailmodenter = waitUtils.waitForVisibility(driver, emailmob, 10);
		emailmodenter.sendKeys(configUtils.getProperty("mobilenumber"));
	}
	public void enterEmailID() {
		WebElement emailmodenter = waitUtils.waitForVisibility(driver, emailmob, 10);
		emailmodenter.sendKeys(configUtils.getProperty("emailid"));
	}
	
	public void clickSubmit() {
		WebElement submitclk = waitUtils.elementToBeClickable(driver, submitbtn, 10);
		submitclk.click();;
	
	}
	
	public boolean verifyEmailClick() {
		WebElement emailenabled = waitUtils.waitForVisibility(driver, mail, 10);
	return emailenabled.isEnabled();
	
	}
	
	public Arieh_UAT_DashboardPage validCrdentials() {
		enterUserName(configUtils.getProperty("usernameArieh"));
		
		enterPassWord(configUtils.getProperty("passwordArieh"));
		clickSubmit();
		return new Arieh_UAT_DashboardPage(driver);
		 
	}
	public void clickOnSendOtp() throws SQLException, InterruptedException {
		WebElement sendotp = waitUtils.waitForPresence(driver, loginbtn, 10);
		sendotp.click();
		
	}
	
	public void clickOnOTP() throws SQLException, InterruptedException {
		WebElement sendotp = waitUtils.waitForPresence(driver,logintosupplier, 10);
		sendotp.click();
		
	}
	
	public void enterOtp() throws SQLException, InterruptedException {
		WebElement otpenter = waitUtils.waitForPresence(driver, otpent, 10);
		String otpfetch = ariehuatresidualpage.retrieveOTPFromDatabase();
		
		otpenter.sendKeys(otpfetch);
	}
	
public void enterIncorrectOtp(String otp) {
	WebElement otpenter = waitUtils.waitForPresence(driver, otpent, 10);
	
	
	otpenter.sendKeys(otp);
    }
	
	public void verifyWithIncorrectOtp() throws SQLException, InterruptedException {
		clickOnSupplier();
		enterEmailID();
		clickOnSendOtp();
		enterIncorrectOtp("1234");
		clickOnOTP();
	}
	
	public Arieh_UAT_SupplierDashboardPage loginToSupplierDashBoard() throws SQLException, InterruptedException {
		clickOnSupplier();
		enterEmailID();
		clickOnSendOtp();
		enterOtp();
		clickOnOTP();
		return new Arieh_UAT_SupplierDashboardPage (driver);
		
	}
	
	
}
