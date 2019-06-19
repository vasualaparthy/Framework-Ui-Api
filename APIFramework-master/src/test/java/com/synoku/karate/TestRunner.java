package com.synoku.karate;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.intuit.karate.junit4.Karate;
import com.synoku.utility.Utilities;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

@RunWith(Karate.class)
@CucumberOptions(features = "classpath:com/synoku/karate", tags = "@U11EISInquiry" ,
				glue= {"stepDefinitions"} ,
				plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"} ,
				monochrome = true
				)
public class TestRunner {
    
	//TestContext testContext;
	@BeforeClass
	public static void setUp() {
		System.setProperty("karate.env", "st2");
	}
	
	@AfterClass
	public static void writeExtentReport() {
		
		Reporter.loadXMLConfig(new File(Utilities.getInstance().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    /* 
	    if (scenario.getName().equals("Some scenario name")) {
			Reporter.assignAuthor("vasu");
		Reporter.addStepLog(â€œStep Log message goes hereâ€�);
		Reporter.addScenarioLog(â€œScenario Log message goes hereâ€�);
		Reporter.addScreenCaptureFromPath(screenshotPath);
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + " - 64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151"); */
	}
	
	/*
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
		
	}
	*/
}
