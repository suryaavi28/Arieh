package com.arieh.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_AddStockPage;
import com.pages.Arieh_UAT_DashboardPage;
import com.pages.Arieh_UAT_DispatchPage;
import com.pages.Arieh_UAT_LoginPage;

public class Arieh_UAT_AddStockPageTest extends TestBase_Arieh{
	Arieh_UAT_LoginPage ariehuatloginpage;
	Arieh_UAT_AddStockPage ariehuataddstockpage;
	Arieh_UAT_DispatchPage ariehuatdispatchpage;
	Arieh_UAT_DashboardPage ariehuatdashboardpage;
	private By allrows=By.xpath("//div/table/tbody/tr");
	 private By firstrowliststock=By.xpath("//tr[1]/td");
		private By secondcolumnliststock=By.xpath("//tr[2]/td");
	
	@BeforeMethod
	public void preBase () {
		setUp();
		ariehuatloginpage = new Arieh_UAT_LoginPage(driver);
		ariehuatdashboardpage = ariehuatloginpage.validCrdentials();
		ariehuatdispatchpage = ariehuatdashboardpage.clickOnDispatch();
		ariehuataddstockpage=ariehuatdispatchpage.clickOnAddStock();
		
	}
	//@Test
	public void testWithSecondRow() {
	    List<WebElement> rows = driver.findElements(allrows); 
	    if (rows.size() > 1) {
	        WebElement secondRow = rows.get(0);
	        List<WebElement> columns = secondRow.findElements(By.tagName("td"));
	        
	        for (WebElement column : columns) {
	            System.out.println(column.getText());
	           
	        } System.out.println(columns.get(1).getText());
	   
	}}
	
	//@Test(invocationCount = 2)
	public void testAddStockcode() throws InterruptedException  {
		ariehuataddstockpage.AddStockAndSubmitOne();
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(allrows); 
	    if (rows.size() > 1) {
	        WebElement firstrow = rows.get(0);
	        List<WebElement> columns = firstrow.findElements(By.tagName("td"));
	     String stockcode=   columns.get(1).getText();
	     long intcurrentstockcode=Long.parseLong(stockcode);
	     WebElement secondrow=rows.get(1);
	     List<WebElement> secondcolumn=secondrow.findElements(By.tagName("td"));
	     String prestockcode = secondcolumn.get(1).getText();
	     long intprestockcode=Long.parseLong(prestockcode);
	     long verifystockcodematch=intprestockcode+1;
	     System.out.println("the current stockcode is"+intcurrentstockcode);
	     System.out.println("the verify stock code is plus"+verifystockcodematch);
	     Assert.assertEquals(intcurrentstockcode, verifystockcodematch);
	     
		
		
	}}
	@Test
	public void testBalanceForNewStock() throws InterruptedException {
		ariehuataddstockpage.AddStockAndSubmitOne();
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(allrows); 
	    if (rows.size() > 1) {
	        WebElement secondrow = rows.get(1);
	        List<WebElement> columns = secondrow.findElements(By.tagName("td"));
	        System.out.println(columns.get(7).getText());
	         double previousbalance = Double.parseDouble(columns.get(7).getText());
	         WebElement firstrow=rows.get(0);
	         List<WebElement> firstrowcolumns=firstrow.findElements(By.tagName("td"));
	         double receivedcurrent = Double.parseDouble(firstrowcolumns.get(5).getText());
	         double usedcurrent = Double.parseDouble(firstrowcolumns.get(6).getText());
	         System.out.println(previousbalance);
	         System.out.println(receivedcurrent);
	         System.out.println(usedcurrent);
	         
	         double actualbalance = previousbalance+receivedcurrent-usedcurrent;
	         System.out.println(actualbalance);
	         double expectedbalance=Double.parseDouble(firstrowcolumns.get(7).getText());
	         Assert.assertEquals(actualbalance, expectedbalance);
	         System.out.println(expectedbalance);
	         
	         
	         
	       
	}
	
	}
	
	@Test
	public void testOpeninForNewStock() throws InterruptedException {
		ariehuataddstockpage.AddStockAndSubmitOne();
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(allrows); 
	    if (rows.size() > 1) {
	        WebElement secondrow = rows.get(1);
	        List<WebElement> columns = secondrow.findElements(By.tagName("td"));
	        System.out.println(columns.get(7).getText());
	         double previousbalance = Double.parseDouble(columns.get(7).getText());
	         WebElement firstrow=rows.get(0);
	         List<WebElement> firstrowcolumns=firstrow.findElements(By.tagName("td"));
	         double receivedcurrent = Double.parseDouble(firstrowcolumns.get(5).getText());
	         double usedcurrent = Double.parseDouble(firstrowcolumns.get(6).getText());
	         
	         double expectedopening= Double.parseDouble(firstrowcolumns.get(4).getText());
	         double actualopening=previousbalance+receivedcurrent;
	         System.out.println(expectedopening);
	         System.out.println(actualopening);
	         Assert.assertEquals(expectedopening, actualopening);
	         
	         
	       
	}
	
	}
//	@Test(invocationCount = 2)
	public void testAddStock2() throws InterruptedException  {
		ariehuataddstockpage.AddStockAndSubmitTwo();
	Thread.sleep(1000);
		

		}
		
		
		
	
	//@Test(invocationCount = 1)
	public void testAddStock3()  {
		ariehuataddstockpage.AddStockAndSubmitThree();
		
	}
	//@Test(invocationCount = 1)
	public void testAddStock4()  {
		ariehuataddstockpage.AddStockAndSubmitFour();
		
	}
	@AfterMethod
	public void tearDownTest() throws InterruptedException {
		//Thread.sleep(2000);
		tearDown();
	}
}
