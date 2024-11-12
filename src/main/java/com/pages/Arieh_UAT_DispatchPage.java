package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_DispatchPage extends Arieh_UAT_AddStockPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
public Arieh_UAT_DispatchPage(WebDriver driver) {
	super(driver);
		this.driver=driver;
		waitUtils = new WaitUtilities();
		// TODO Auto-generated constructor stub
	}




private By addstock = By.id("bt_next");
private By dispatch= By.xpath("//div[contains(text(),'Dispatch')]");
private By adddispatch=By.xpath("//span[contains(text(),'Add Dispatch')]");


	

	public Arieh_UAT_AddStockPage clickOnAddStock() {
		WebElement add = waitUtils.elementToBeClickable(driver, addstock, 10);
		add.click();
		return new Arieh_UAT_AddStockPage(driver);
	}
	
	public void clickOnAddStockMultiple() {
		WebElement add = waitUtils.elementToBeClickable(driver, addstock, 10);
		add.click();
		
	}
	public void clickOnAddStockOnSamePage() {
		
		
		AddStockAndSubmitOne();
		
	}
	public void clickOnTheDispatch() {
		WebElement dispatchclick= waitUtils.elementToBeClickable(driver, dispatch, 10);
		dispatchclick.click();
	}
	
	public void clickOnTheAddDispatchTab() {
		WebElement clickadddispatch=waitUtils.elementToBeClickable(driver, adddispatch, 10);
		clickadddispatch.click();
	}
	
	public Arieh_UAT_AddDispatchPage clickOnTheAddDispatch() {
		clickOnTheDispatch();
		clickOnTheAddDispatchTab();
		return new Arieh_UAT_AddDispatchPage(driver);
	}
	
	public Arieh_UAT_MultipleAddStockPage clickOnTheAddStocks() {
		
		return new Arieh_UAT_MultipleAddStockPage(driver);
	}
	
	
	
	
}
