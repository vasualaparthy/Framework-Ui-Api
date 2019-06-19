package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.BaseTest;

public class Utility {
	public static Properties OR;
	
	
	public static By getLocatorElement(String orName, String sLocator, String sLocator_Property) {
		By byProperty = null;
		try {
			switch(sLocator) {
			case "css":
				byProperty = By.cssSelector(sLocator_Property);
				break;
			case "id":
				byProperty = By.id(sLocator_Property);
				break;
			case "linkText":
				byProperty = By.linkText(sLocator_Property);
				break;
			case "name":
				byProperty = By.name(sLocator_Property);
				break;
			case "partialLinkText":
				byProperty = By.partialLinkText(sLocator_Property);
				break;
			case "tagName":
				byProperty = By.tagName(sLocator_Property);
				break;
			case "xpath":
				byProperty = By.xpath(sLocator_Property);
				break;
			case "className":
				byProperty = By.className(sLocator_Property);
				break;
			default:
				byProperty = By.xpath(sLocator_Property);
				break;
		}
		} catch(Exception e) {
			return null;
		}
		
		return byProperty;
	}
	
	public static By getLocator(String orName, String sPropertyName) {
		By byProperty = null;

		try {
			FileInputStream fs = new FileInputStream("config/" + orName + ".properties");
	        OR= new Properties();
	        OR.load(fs);
			String sProperty = OR.getProperty(sPropertyName);
			
			String[] arrProperty = sProperty.split("=", 2);
			String sLocator = arrProperty[0];
			String sLocator_Property = arrProperty[1];

			// Find the Element Property to be used for Identifying the Object
			byProperty = getLocatorElement(orName, sLocator, sLocator_Property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byProperty;
	}
	
	public static By getLocator(String orName, String sPropertyName, String textChange) {
		By byProperty = null;

		try {
			FileInputStream fs = new FileInputStream("config/" + orName + ".properties");
	        OR= new Properties();
	        OR.load(fs);
			String sProperty = OR.getProperty(sPropertyName);
			
			String[] arrProperty = sProperty.split("=", 2);
			String sLocator = arrProperty[0];
			String sLocator_Property = arrProperty[1];
			sLocator_Property = sLocator_Property.replace("textChangeInput", textChange);
			
			// Find the Element Property to be used for Identifying the Object
			byProperty = getLocatorElement(orName, sLocator, sLocator_Property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byProperty;
	}
	
	public static String getPropValues(String propPath, String sProperty) {
		String sResult = "";
		InputStream input = null;
		try {
			Properties prop = new Properties();
			input = new FileInputStream(System.getProperty("user.dir")
					+ "\\OR\\" + propPath + ".properties");
			prop.load(input);
			sResult = prop.getProperty(sProperty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sResult;
	}

	/**
	 * Returns the Value for the Key mentioned in Config File
	 * 
	 * @param sProperty
	 * @return
	 */
	public static String getConfigValues(String sProperty) {
		String sValue = "";
		InputStream input = null;
		try {
			Properties prop = new Properties();
			input = new FileInputStream(System.getProperty("user.dir")
					+ "\\Config\\Config" + ".properties");
			prop.load(input);
			sValue = prop.getProperty(sProperty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sValue;
	}

	public static String returnLogFilePath() throws IOException {
		String TimeStamp = fn_GetCurrentTimeStamp();
		String FolderPath = System.getProperty("user.dir")
				+ "\\Output\\Logs\\application_" + TimeStamp + "\\";
		File FolderObj = new File(FolderPath);
		FolderObj.mkdir();
		FolderPath = FolderObj.getAbsolutePath();
		String FullFilePath = FolderPath + "\\" + "application.log";
		System.setProperty("filename", FullFilePath);
		return FullFilePath;

	}

	/* Method for taking the Screen Shot End */
	// This Method Return the Date as String
	public static String fn_GetCurrentTimeStamp() {
		Date dte = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String strdte = df.format(dte);
		strdte = strdte.replaceAll(":", "_");
		return strdte;
	}
	
	public static WebElement getElement(WebDriver driver, String orName, String eleName) {
		WebElement ele = null;
		try {
		By loc = Utility.getLocator("or", eleName);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		} catch(Exception e)  {
			return null;
		}
		return ele;
	}
	
	public static WebElement getElement(WebDriver driver, String orName, String eleName, int timeout) {
		WebElement ele = null;
		try {
		By loc = Utility.getLocator("or", eleName);
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		} catch(Exception e)  {
			return null;
		}
		return ele;
	}
	
	public static WebElement getElement(WebDriver driver, String orName, String eleName, String textChange) {
		WebElement ele = null;
		try {
		By loc = Utility.getLocator("or", eleName, textChange);
		int number  = Integer.parseInt(BaseTest.CONFIG.getProperty("timeWaitForEachElement"));
		WebDriverWait wait = new WebDriverWait(driver, number);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		} catch(Exception e)  {
			return null;
		}
		return ele;
	}

	/** 
	 * The function fetches all the web elements from the locator specified
	 * @param driver
	 * @param orName
	 * @param eleName
	 * @return
	 */
	public static List<WebElement> getAllElement(WebDriver driver, String orName, String eleName) {
		List<WebElement> ele = null;
		try {
		By loc = Utility.getLocator("or", eleName);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
		} catch(Exception e)  {
			return null;
		}
		return ele;
	}
}
