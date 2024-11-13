package com.arieh.tests;

import java.net.MalformedURLException;
import java.sql.SQLException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.arieh.base.TestBase_Arieh;
import com.pages.Arieh_UAT_ResidualPage;

public class Arieh_UAT_ResidualPageTest extends TestBase_Arieh {
    Arieh_UAT_ResidualPage residualPage;

   // @BeforeMethod
    public void setUpTest() throws MalformedURLException {
        setUp();
        residualPage = new Arieh_UAT_ResidualPage(driver);
    }

 //   @Test
    public void testDeleteStockAndDispatch() throws SQLException, InterruptedException {
    	residualPage = new Arieh_UAT_ResidualPage(driver);
    	residualPage.deleteStockAndDispatch();
    }
    @Test
    public void testWithOtpRetireve() throws SQLException, InterruptedException {
    	residualPage = new Arieh_UAT_ResidualPage(driver);
    	residualPage.retrieveOTPFromDatabase();
    }
    

    //@AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
