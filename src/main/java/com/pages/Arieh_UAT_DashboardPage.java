package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitUtilities;

public class Arieh_UAT_DashboardPage {
WebDriver driver;
WaitUtilities waitUtils;

private By dispatch= By.id("Dispatch");
	public Arieh_UAT_DashboardPage(WebDriver driver) {
		this.driver=driver;
		waitUtils = new WaitUtilities();
		
		
	}
	
public Arieh_UAT_DispatchPage clickOnDispatch() {
	WebElement dispatchcl= waitUtils.elementToBeClickable(driver, dispatch, 10);
	dispatchcl.click();
	return new Arieh_UAT_DispatchPage(driver);
}

	
	
}
