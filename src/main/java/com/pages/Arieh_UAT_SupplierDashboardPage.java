package com.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_SupplierDashboardPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	ReadConfigUtilities readconfig;
	
public Arieh_UAT_SupplierDashboardPage(WebDriver driver) {
	 this.driver=driver;
		waitUtils = new WaitUtilities();
		readconfig=  new ReadConfigUtilities();
		readconfig.readCOnfig();
}

private By dispatchclick = By.xpath("//label[contains(text(),'Dispatch')]");


public Arieh_UAT_SupplierStockPage clickOnDispatch() {
	WebElement dispatchclickontab= waitUtils.elementToBeClickable(driver, dispatchclick, 5);
	dispatchclickontab.click();
	return new Arieh_UAT_SupplierStockPage(driver);
}



}
