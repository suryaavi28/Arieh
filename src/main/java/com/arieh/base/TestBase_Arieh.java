package com.arieh.base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import com.utils.ReadConfigUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase_Arieh {

	public static WebDriver driver;
	 static ReadConfigUtilities configUtils;
	  @BeforeSuite
	    public void cleanAllureResults() {
	        File allureResultsFolder = new File("allure-results");
	        if (allureResultsFolder.exists()) {
	            for (File file : allureResultsFolder.listFiles()) {
	                file.delete();
	            }
	            allureResultsFolder.delete();
	        }
	        System.out.println("Allure results folder cleaned.");
	    }
	public static void setUp() {
		configUtils = new ReadConfigUtilities();
		configUtils.readCOnfig();
		String browser = configUtils.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			//WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			//WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Please provide correct browser");
		}
		
		driver.manage().window().maximize();
		String url = configUtils.getProperty("urlArieh");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	public static WebDriver getDriver() {
        return driver;
    }
	  
    public void tearDown() {
        driver.quit();
    }
	
}
