package com.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_AddDispatchPage {

	WebDriver driver;
	WaitUtilities waitUtils;
	ReadConfigUtilities readconfig;
	Random random;
	
	public Arieh_UAT_AddDispatchPage(WebDriver driver) {
		this.driver=driver;
		waitUtils = new WaitUtilities();
		readconfig=  new ReadConfigUtilities();
		readconfig.readCOnfig();
		random=new Random();
		
	}
	
	private By dispatch= By.xpath("//div[contains(text(),'Dispatch')]");
	private By adddispatch=By.xpath("//span[contains(text(),'Add Dispatch')]");
	private By invoiceno=By.xpath("//input[@id='txt_invoice']");
	private By materialcode=By.xpath("//div[@role='option']");
	private By billdate=By.id("txt_sd");
	

	
	
	public void clickOnTheAddDispatchTab() {
		WebElement clickadddispatch=waitUtils.elementToBeClickable(driver, adddispatch, 10);
		clickadddispatch.click();
	}
	
	public void clickOnTheDispatch() {
		WebElement dispatchclick= waitUtils.elementToBeClickable(driver, dispatch, 10);
		dispatchclick.click();
	}
	public void addDispatchReopen() {
		clickOnTheDispatch();
		clickOnTheAddDispatch();
		
	}
	
	public void enterInvoiceNumber() {
		WebElement invoice = waitUtils.elementToBeClickable(driver, invoiceno, 10);
		int randomint = 23434323+random.nextInt(42346843);
		String randomintstr = String.valueOf(randomint);
		invoice.sendKeys(randomintstr);
	}
	
	public void selectMaterialCode() {
		List <WebElement> materials= driver.findElements(materialcode);
		materials.remove(0);
	for( WebElement material:materials) {
		int intrandomcode=random.nextInt(materials.size());
		WebElement randommaterialcode = materials.get(intrandomcode);
		randommaterialcode.click();
	}}
	
	public void enterBillDate() {
		WebElement datefield = waitUtils.elementToBeClickable(driver, billdate, 10);
		datefield.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // Perform Enter key action 2 times
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();	
		
	}
	
	
	
	
	
	public void  clickOnTheAddDispatch(){
		
				enterInvoiceNumber();
		selectMaterialCode();
		enterBillDate();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}