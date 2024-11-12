package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;



public class Arieh_UAT_AddStockPage {

	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Random random;
	
	private By addstock = By.id("bt_next");
	private By selectSupplier = By.xpath("//div[@role='option']");
	private By date = By.id("txt_sd");
	private By received= By.id("txt_recieved");
	private By submit=By.xpath("//button[@class='button-submit'][text()='Submit'][@xpath='4']");
	private By clicksupplier=By.id("dd_supplierName");
	private By clickonly = By.id("myModalLabel2");
	private By uploadstock=By.id("bt_upload");
	private By draganddrop=By.xpath("//div[@class='container upload-block']");
	
	
	
	public Arieh_UAT_AddStockPage(WebDriver driver){
		this.driver=driver;
		waitUtils= new  WaitUtilities();
		configUtils = new ReadConfigUtilities();
		configUtils.readCOnfig();
	}
	

	
	public void clickOnAddStockagain() {
		WebElement add = waitUtils.elementToBeClickable(driver, addstock, 10);  // Wait for the element to be clickable
        
        // Use JavascriptExecutor to click the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", add);
	}
	
	public void selectSupplierOne() {
		WebElement clicksupp=waitUtils.elementToBeClickable(driver, clicksupplier, 10);
		clicksupp.click();
		
		
		
		List<WebElement> supplierList = driver.findElements(selectSupplier);
		for( WebElement sup: supplierList) {
			if (sup.getText().equalsIgnoreCase("UAT_ONE")) {
				sup.click();
				break;
			}
		}
	}
	public void selectSupplierTwo() {
		WebElement clicksupp=waitUtils.elementToBeClickable(driver, clicksupplier, 10);
		clicksupp.click();
		
		
		
		List<WebElement> supplierList = driver.findElements(selectSupplier);
		for( WebElement sup: supplierList) {
			if (sup.getText().equalsIgnoreCase("UAT_TWO")) {
				sup.click();
				break;
			}
		}
	}
	public void selectSupplierThree() {
		WebElement clicksupp=waitUtils.elementToBeClickable(driver, clicksupplier, 10);
		clicksupp.click();
		
		
		
		List<WebElement> supplierList = driver.findElements(selectSupplier);
		for( WebElement sup: supplierList) {
			if (sup.getText().equalsIgnoreCase("UAT_THREE")) {
				sup.click();
				break;
			}
		}
	}
	public void selectSupplierFOUR() {
		WebElement clicksupp=waitUtils.elementToBeClickable(driver, clicksupplier, 10);
		clicksupp.click();
		
		
		
		List<WebElement> supplierList = driver.findElements(selectSupplier);
		for( WebElement sup: supplierList) {
			if (sup.getText().equalsIgnoreCase("UAT_FOUR")) {
				sup.click();
				break;
			}
		}
	}
	

public void selectDate() {
	  
	    // Find the date input field
	    WebElement dateField = waitUtils.waitForPresence(driver, date, 10); 
	    dateField.click();
	    Actions actions = new Actions(driver);

        // Perform Tab key action 4 times
	    

        // Perform Tab key action 3 times
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // Perform Enter key action 2 times
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();	    // Use JavaScript to set the value of the date input field
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("arguments[0].value = '" + formattedDate + "';", dateField);
}

	
	public void enterReceivedQuantity() {
		WebElement receivedq = waitUtils.waitForVisibility(driver, received, 10);
		Random random = new Random();
	int	randquantity= 12+random.nextInt(20);
	String randomqan= String.valueOf(randquantity);
	receivedq.sendKeys(randomqan);
	Actions actions = new Actions(driver);
	actions. sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
	actions. sendKeys(Keys.ENTER).perform();
	
	}
	
	
	public void clickOnSubmit() {
		WebElement btn = waitUtils.elementToBeClickable(driver, submit, 5);
		btn.click();

	}
	
	public void AddStockAndSubmitOne() {
//		clickOnAddStock();
		selectSupplierOne();
		selectDate();
		enterReceivedQuantity();
		
		//clickOnSubmit();
		
	}
	public void clickOnAddStock1() {
	   
	            WebElement add = waitUtils.waitForVisibility(driver, addstock, 10);
	            add.click();  // Attempt to click the element
	             // If click is successful, set isClicked to true to exit loop
	      
	    }

	  



	public Arieh_UAT_DispatchPage AddStockAndSubmitTwo() {
		clickOnAddStock1();
		selectSupplierTwo();
		selectDate();
		enterReceivedQuantity();
		return new Arieh_UAT_DispatchPage(driver);
		//clickOnSubmit();
		
	}
	public void AddStockAndSubmitThree() {
		clickOnAddStock1();
		selectSupplierThree();
		selectDate();
		enterReceivedQuantity();
		//clickOnSubmit();
		
	}
	public void AddStockAndSubmitFour()  {
	
		clickOnAddStock1();
		selectSupplierFOUR();
		selectDate();
		enterReceivedQuantity();
	//	clickOnSubmit();
		
	}
}
