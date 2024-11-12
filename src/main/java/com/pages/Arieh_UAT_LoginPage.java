package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_LoginPage {

	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	
	
	public Arieh_UAT_LoginPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities();
		configUtils.readCOnfig();
		
	}
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By submitbtn = By.xpath("//button[@type='submit']");
	public By mail = By.xpath("//div[@class='help-email']");
	
	
	
	public void enterUserName(String un) {
		WebElement enterun = waitUtils.waitForVisibility(driver, username, 10);
		enterun.sendKeys(un);
	
	}
	
	public void enterPassWord(String pw) {
		WebElement enterpw = waitUtils.waitForVisibility(driver, password, 10);
		enterpw.sendKeys(pw);
	
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
	
	
	
	
}
