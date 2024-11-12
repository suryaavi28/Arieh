	package com.pages;
	
	import java.util.Random;
	
	import org.openqa.selenium.WebDriver;
	
	import com.utils.ReadConfigUtilities;
	import com.utils.WaitUtilities;
	
	public class Arieh_UAT_MultipleAddStockPage extends Arieh_UAT_AddStockPage {
	WebDriver driver;
	ReadConfigUtilities configUtils;
	Random random;
	WaitUtilities waitUtils;
		
		
		public Arieh_UAT_MultipleAddStockPage(WebDriver driver) {
			super(driver);
			WaitUtilities waitUtils = new WaitUtilities();
			configUtils = new  ReadConfigUtilities();
			configUtils.readCOnfig();
			
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
