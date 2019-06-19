package com.synoku.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	public Properties getConfigProp() {
		Properties p = null;
	    try {
	    		FileReader reader=new FileReader("configs/config.properties");  
		      
		    p=new Properties();  
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    return p;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath;
		reportConfigPath = getConfigProp().getProperty("reportConfigPath");
		if(reportConfigPath!= null) 
			return reportConfigPath;
		else 
			throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public static Utilities getInstance() {
		
		return new Utilities();
	}
	
}
