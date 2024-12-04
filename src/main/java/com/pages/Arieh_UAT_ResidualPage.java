package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utils.ReadConfigUtilities;
import com.utils.WaitUtilities;



public class Arieh_UAT_ResidualPage {
	WebDriver driver;
    WaitUtilities waitUtils;
    static ReadConfigUtilities configUtils;
    
    
    public Arieh_UAT_ResidualPage(WebDriver driver) {
       
        this.driver = driver;
        waitUtils = new WaitUtilities();
        configUtils = new ReadConfigUtilities();
        configUtils.readCOnfig();
    }

    public  void deleteStockAndDispatch() throws SQLException, InterruptedException {
        String jdbcUrl = "jdbc:sqlserver://10.212.87.140\\MSSQLSERVER:1433;databaseName=PPG;encrypt=true;trustServerCertificate=true";
        String username = "QaSupport";
        String password = "QaSupport@123";
        
        String Dispatchdelete="delete from PPG.PPGranulesInvoice";
        String Stockdelete="delete from PPG.SupplierInventory";
        
        Connection connection = null;
        Statement statement = null;
        try {
            
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            statement = connection.createStatement();
            statement.executeUpdate(Dispatchdelete);
            statement.executeUpdate(Stockdelete);
    }
        catch (SQLException e) {
            
        	
            throw e; // rethrow the exception if necessary
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public String retrieveOTPFromDatabase() throws SQLException, InterruptedException {
        String jdbcUrl = "jdbc:sqlserver://10.212.87.140\\MSSQLSERVER:1433;databaseName=PPG;encrypt=true;trustServerCertificate=true";
        String username = "DevSupport";
        String password = "DevSupport@123";
        
        String query = "select otp from ppg.otp_temp where user_id='dsaf@gf.com'";
        
        String otp = "";
        Connection connection = null;
        Statement statement = null;
        
        try {
            
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            statement = connection.createStatement();
            
            Thread.sleep(1000); // Add sleep between creating statement and executing query

           
            try (ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    otp = resultSet.getString("otp");
                    System.out.println("Otp for the bcd   is   "+otp );
                }
            }
        } catch (SQLException e) {
          
            throw e; // rethrow the exception if necessary
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return otp;
    }
	
}
