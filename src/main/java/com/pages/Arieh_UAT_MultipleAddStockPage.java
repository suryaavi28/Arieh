	package com.pages;
	
	import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ReadConfigUtilities;
	import com.utils.WaitUtilities;
	
	public class Arieh_UAT_MultipleAddStockPage extends Arieh_UAT_AddStockPage {
	WebDriver driver;
	ReadConfigUtilities configUtils;
	Random random;
	WaitUtilities waitUtils;
	
	private By uploadstock=By.id("bt_upload");
	private By draganddrop=By.xpath("//div[@class='container upload-block']");
	private By uploadfilebutton= By.xpath("//button[normalize-space()='Upload File']");
	
		
		
	public Arieh_UAT_MultipleAddStockPage(WebDriver driver) {
	    super(driver);
	    this.driver = driver; // Add this line to initialize driver
	    waitUtils = new WaitUtilities();
	    configUtils = new ReadConfigUtilities();
	    configUtils.readCOnfig();
	}
		
	public void uploadFile() {
		WebElement upload = waitUtils.elementToBeClickable(driver, uploadfilebutton, 10);
		upload.click();
	}
	
	
  public void AddStockExcel() throws Exception {
	  verifyUploadStockClick();
	  Thread.sleep(2000);
	  verifyDragandDrop();
	  uploadFile();
	  Thread.sleep(2000);
	  
  }


  public void verifyUploadStockClick() {
		WebElement upload= waitUtils.waitForVisibility(driver, uploadstock, 10);
		upload.click();
	}
	
	public void verifyDragandDrop() throws InterruptedException  {
		WebElement drag= waitUtils.waitForPresence(driver, draganddrop, 10);
		drag.click();
		Thread.sleep(2000);
		String autoITScripts = "C:\\Users\\avisu\\eclipse-workspace\\arieh\\src\\test\\resources\\StockUploadexcel.exe";
		try {
			Runtime.getRuntime().exec(autoITScripts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
		public void enterMultipleStock() throws InterruptedException {
	
			Runnable[]  AddStocks = new  Runnable[] {
				this::AddStockAndSubmitOne,
				this::AddStockAndSubmitTwo,
				this::AddStockAndSubmitThree,
				this::AddStockAndSubmitFour};
		for(Runnable add : AddStocks) {
			Thread.sleep(2000);
			clickOnAddStock1();
			Thread.sleep(2000);
			add.run();
			Thread.sleep(2000);
			
		}
		
		}
	
	}
