package com.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;

public class Arieh_UAT_SupplierDashboardPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	ReadConfigUtilities readconfig;
	
public Arieh_UAT_SupplierDashboardPage(WebDriver driver) {
	 this.driver=driver;
		waitUtils = new WaitUtilities();
		readconfig=  new ReadConfigUtilities();
		readconfig.readCOnfig();
}


}
