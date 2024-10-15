package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigUtilities {
	 	private Properties properties;
	    public void readCOnfig() {
	    	properties = new Properties();
	    	String configFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	    	try {
				FileInputStream fileInputStream = new FileInputStream(configFilePath);
				
					properties.load(fileInputStream);
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
	    	
	    	
	    }
	    
	    public String getProperty(String key) {
	    	return properties.getProperty(key);
	    	
	    }
	    
	    
	    
	   
	    
	    
}
