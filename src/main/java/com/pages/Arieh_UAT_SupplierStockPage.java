package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_SupplierStockPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	ReadConfigUtilities readconfig;
	
public Arieh_UAT_SupplierStockPage(WebDriver driver) {
	 this.driver=driver;
		waitUtils = new WaitUtilities();
		readconfig=  new ReadConfigUtilities();
		readconfig.readCOnfig();
}


private By dispatchtab = By.xpath("//div[contains(text(),'Dispatch')]");

public Arieh_UAT_SupplierAddDispatchPage clickOnDispatchTab() {
	WebElement dispatchclcik=waitUtils.elementToBeClickable(driver, dispatchtab, 5);
	dispatchclcik.click();
	return new Arieh_UAT_SupplierAddDispatchPage(driver);
	
}

















}














