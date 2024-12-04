package com.arieh.tests;

import java.io.IOException;
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

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Arieh_UAT_AddStockPageTest extends TestBase_Arieh{
	Arieh_UAT_LoginPage ariehuatloginpage;
	Arieh_UAT_AddStockPage ariehuataddstockpage;
	Arieh_UAT_DispatchPage ariehuatdispatchpage;
	Arieh_UAT_DashboardPage ariehuatdashboardpage;
	private By allrows=By.xpath("//div/table/tbody/tr");
	 private By firstrowliststock=By.xpath("//tr[1]/td");
		private By secondcolumnliststock=By.xpath("//tr[2]/td");
	
	

		    @BeforeMethod
		    public void preBase() {
		        setUp();
		        ariehuatloginpage = new Arieh_UAT_LoginPage(driver);
		        ariehuatdashboardpage = ariehuatloginpage.validCrdentials();
		        ariehuatdispatchpage = ariehuatdashboardpage.clickOnDispatch();
		        ariehuataddstockpage = ariehuatdispatchpage.clickOnAddStock();
		    }
		    
		    @Test
		    public void testWithSecondRow() {
		        List<WebElement> rows = driver.findElements(allrows);
		        if (rows.size() > 1) {
		            WebElement secondRow = rows.get(1);
		            List<WebElement> columns = secondRow.findElements(By.tagName("td"));
		            Assert.assertNotNull(columns, "Second row columns are null");
		        }
		    }

		    @Test
		    public void testAddStockCode() throws InterruptedException {
		        ariehuataddstockpage.AddStockAndSubmitOne();
		        Thread.sleep(1000);
		        List<WebElement> rows = driver.findElements(allrows);
		        if (rows.size() > 1) {
		            WebElement firstRow = rows.get(0);
		            List<WebElement> columns = firstRow.findElements(By.tagName("td"));
		            long currentStockCode = Long.parseLong(columns.get(1).getText());

		            WebElement secondRow = rows.get(1);
		            List<WebElement> secondColumns = secondRow.findElements(By.tagName("td"));
		            long previousStockCode = Long.parseLong(secondColumns.get(1).getText());

		            long expectedStockCode = previousStockCode + 1;
		            Assert.assertEquals(currentStockCode, expectedStockCode, "Stock code does not match the expected value.");
		        }
		    }

		    @Test
		    public void testBalanceForNewStock() throws InterruptedException {
		        ariehuataddstockpage.AddStockAndSubmitOne();
		        Thread.sleep(1000);
		        List<WebElement> rows = driver.findElements(allrows);
		        if (rows.size() > 1) {
		            WebElement secondRow = rows.get(1);
		            List<WebElement> columns = secondRow.findElements(By.tagName("td"));
		            double previousBalance = Double.parseDouble(columns.get(7).getText());

		            WebElement firstRow = rows.get(0);
		            List<WebElement> firstRowColumns = firstRow.findElements(By.tagName("td"));
		            double receivedCurrent = Double.parseDouble(firstRowColumns.get(5).getText());
		            double usedCurrent = Double.parseDouble(firstRowColumns.get(6).getText());

		            double actualBalance = previousBalance + receivedCurrent - usedCurrent;
		            double expectedBalance = Double.parseDouble(firstRowColumns.get(7).getText());
		            Assert.assertEquals(actualBalance, expectedBalance, "Balance calculation is incorrect.");
		        }
		    }

		    @Test
		    public void testOpeningForNewStock() throws InterruptedException {
		        ariehuataddstockpage.AddStockAndSubmitTwo();
		        Thread.sleep(1000);
		        List<WebElement> rows = driver.findElements(allrows);
		        if (rows.size() > 1) {
		            WebElement secondRow = rows.get(1);
		            List<WebElement> columns = secondRow.findElements(By.tagName("td"));
		            double previousBalance = Double.parseDouble(columns.get(7).getText());

		            WebElement firstRow = rows.get(0);
		            List<WebElement> firstRowColumns = firstRow.findElements(By.tagName("td"));
		            double receivedCurrent = Double.parseDouble(firstRowColumns.get(5).getText());

		            double expectedOpening = Double.parseDouble(firstRowColumns.get(4).getText());
		            double actualOpening = previousBalance + receivedCurrent;
		            Assert.assertEquals(actualOpening, expectedOpening, "Opening balance calculation is incorrect.");
		        }
		    }
		
		
		
		    @Test
		    public void testAddStock3()  {
		ariehuataddstockpage.AddStockAndSubmitThree();
		
	}
		    
		    
    
	@Test(invocationCount = 1)
	public void testAddStock4()  {
		ariehuataddstockpage.AddStockAndSubmitFour();
		
	}
	@AfterMethod
	public void tearDownTest() throws InterruptedException {
		//Thread.sleep(2000);
		tearDown();
	}
}
