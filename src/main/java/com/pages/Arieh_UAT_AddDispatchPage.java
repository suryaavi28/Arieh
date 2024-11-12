package com.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	private By adddispatch=By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[2]/app-dispatch[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/span[1]");
	private By invoiceno=By.xpath("//input[@id='txt_invoice']");
	private By materialcode=By.xpath("//div[@role='option']");
	private By materialplace= By.id("dd_materialCode");
	private By billdate=By.xpath("//input[@id='txt_bd']");
	private By bagqty = By.xpath("//input[@id='txt_bagQty']");
	private By selectplant=By.id("dd_plant");
	private By plantdropdown=By.xpath("//div[@class='ng-option']");
	private By supplierclick=By.xpath("//ng-select[@id='dd_supplier']");
	private By estimateddate = By.xpath("//input[@id='txt_edd']");
	private By  selectsupplier = By.xpath("//div[@role='option']");
	private By submitbtn = By.xpath("//button[@id='dispatchClose']/following-sibling::button[@class='button-submit']");
	
	

	public void enterEstimatedDate() {
		WebElement date = waitUtils.elementToBeClickable(driver, estimateddate, 10);
		date.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // Perform Enter key action 2 times
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();
	}
	
	public void clickOnTheAddDispatchTab() {
		WebElement clickadddispatch=waitUtils.elementToBeClickable(driver, adddispatch, 10);
		clickadddispatch.click();
		System.out.println(clickadddispatch.isDisplayed());
		System.out.println(clickadddispatch.isEnabled());
	}
	
	public void clickOnTheDispatch() {
		WebElement dispatchclick= waitUtils.elementToBeClickable(driver, dispatch, 10);
		dispatchclick.click();
	}
	public void addDispatchReopen() throws InterruptedException {
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
		WebElement materialcodes = waitUtils.elementToBeClickable(driver, materialplace, 10);
		materialcodes.click();
		List <WebElement> materials= driver.findElements(materialcode);
		materials.remove(0);
//	for( WebElement material:materials) {
		int intrandomcode=random.nextInt(materials.size());
		WebElement randommaterialcode = materials.get(intrandomcode);
		System.out.println(randommaterialcode.getText());
		randommaterialcode.click();
	}
	
	public void enterBillDate() {
		WebElement datefield = waitUtils.elementToBeClickable(driver, billdate, 10);
		datefield.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // Perform Enter key action 2 times
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();	
		
	}
	
	
	
	
	public void enterBagQty() {
		WebElement submitbtnclick = waitUtils.elementToBeClickable(driver, submitbtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", submitbtnclick);

		int randomint =34343+ random.nextInt(98656-56653);
		String qty= String.valueOf(randomint);
	WebElement bagTextBox =	waitUtils.waitForPresence(driver, bagqty, 10);
	bagTextBox.sendKeys(qty);
		
		
		
		
	}
	public void selectPlant() {
		WebElement submitbtnclick = waitUtils.elementToBeClickable(driver, submitbtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", submitbtnclick);
		WebElement plant = waitUtils.elementToBeClickable(driver, selectplant, 10);
		plant.click();
		List<WebElement> plantlist = driver.findElements(plantdropdown);
		int randomplant = random.nextInt(plantlist.size());
		WebElement selectplantname = plantlist.get(randomplant);
		selectplantname.click();
		}
		
	
	public void selectSupplierName() {
		
		WebElement supplier = waitUtils.elementToBeClickable(driver, supplierclick, 10);
		supplier.click();
		List<WebElement> supplierAll = driver.findElements(selectsupplier);
		
		supplierAll.remove(0);
		for (WebElement suppliers : supplierAll) {
			
			if (suppliers.getText().equalsIgnoreCase("UAT_ONE")){
				suppliers.click();
				break;
			}
			
		}
	}
	
	public void submitClick() {
		WebElement submit = waitUtils.elementToBeClickable(driver, submitbtn, 10);
		submit.click();
	}
	
	
	
	public void  clickOnTheAddDispatch() throws InterruptedException{
		Thread.sleep(2000);
		clickOnTheAddDispatchTab();
				enterInvoiceNumber();
				Thread.sleep(1000);
		selectMaterialCode();
		
		enterBillDate();
		
		enterBagQty();
		
		
		selectPlant();
		
		enterEstimatedDate();
		selectSupplierName();
		
		submitClick();
		Thread.sleep(4000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}