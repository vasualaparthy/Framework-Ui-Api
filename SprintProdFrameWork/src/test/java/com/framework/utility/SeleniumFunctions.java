package com.framework.utility;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.utils.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import tests.BaseTest;

	//Switch Functions
	public class SeleniumFunctions {
		public WebDriver driver;
	    public WebDriverWait wait;

	    //Constructor
	    public SeleniumFunctions (WebDriver driver, WebDriverWait wait){
	        this.driver = driver;
	        this.wait = wait;
	    }

	    //Click Method
	    public static void click (WebDriver driver, String ele) throws InterruptedException {
	    	WebElement element = Utility.getElement(driver, "or", ele);
	    	Thread.sleep(1000);
	        element.click();
	    }
	    
	    public static void click (WebDriver driver, String ele, String textChange) throws InterruptedException {
	    	WebElement element = Utility.getElement(driver, "or", ele, textChange);
	    	Thread.sleep(1000);
	        element.click();
	    }

	    //Write Text
	    public  static void writeText (WebDriver driver, By elementLocation, String text) {
	        driver.findElement(elementLocation).sendKeys(text);
	    }

	    //Read Text
	    public String readText (By elementLocation) {
	        return driver.findElement(elementLocation).getText();
	    }
	    
	  //Read Text
	    public static String readProperty (WebDriver driver, String element, String prop) {
	    	WebElement ele = Utility.getElement(driver, "or", element, "100");
	        return ele.getAttribute(prop);
	    }
	    
	    public static void elementContainInfo (WebDriver driver, String ele, String expMsg, String msg) {
	    	List<WebElement> elements = Utility.getAllElement(driver, "or", ele);
	    	String actMsg = "";
	    	Boolean status = false;
	    	for (WebElement element : elements) {
	    		actMsg = element.getText();
	    		System.out.println("Actual Msg: " + actMsg);
	    		if (actMsg.toLowerCase().trim().contains(expMsg.toLowerCase().trim())) {
	    			status = true;
	    			break;
	    		}
	    	}
	    	System.out.println("Exp Msg -" + expMsg);
	        Assert.assertTrue(status, msg + expMsg);
	        if (status)
				ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed",msg + expMsg);
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed","Actual Msg -" + actMsg + " and Exp Msg -" + expMsg);
	    }
	    
	    /**
	 * switch to window handle based on handle name
	 * 
	 * @param driver
	 * @param wndHandle
	 */
	   public static Boolean switchToWindowHandle(WebDriver driver, String wndHandle) {
		   
		try {
		//logger.info("inside switchtowindowhandle Method");
		Set<String> handler = driver.getWindowHandles();
		for (String handlesname : handler) {
			driver.switchTo().window(handlesname);
			String var = driver.getTitle();
			System.out.println("Window found: " + var);
			//logger.info("window Handle --> " + var);
			if (var.toLowerCase().contains(wndHandle.toLowerCase())) {
				//logger.info("Title matched hence switching to handle " + wndHandle);
				driver.switchTo().window(handlesname);
				System.out.println("Window Switched: " + var);
				return true;
			} else {
				driver.switchTo().defaultContent();
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * Switch to window handle
	 * 
	 * @param driver
	 * @param wndHandle
	 */
	public static void switchToWindowHandleDirect(WebDriver driver, String wndHandle) {
		driver.switchTo().window(wndHandle);
	}
	
	/**
	 * Switch back to the Main or Default Window
	 * 
	 * @param driver
	 */
	public static WebDriver switchToDefault(WebDriver driver) {

		try {
			//logger.info("Switch to Default Content");
			return driver.switchTo().defaultContent();
		} catch (Exception e) {
			//logger.error("Error Occured while switch to default windiw ");
		}
		return driver;
	}
	

	/**
	 * Waits and Switches to the Frame
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param locator
	 * @throws InterruptedException
	 */
	public static void waitAndSwitchToFrame(WebDriver driver,
			int timeOutInSeconds, By locator) throws InterruptedException {
		waitForPageLoad(driver);
		//logger.info("Switching to Frame" + locator.toString());
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	/**
	 * Waits and Switched to the Frame found by its Id or Name
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param sFrameName
	 * @throws InterruptedException
	 */
	public static void waitAndSwitchToFrame(WebDriver driver,
			int timeOutInSeconds, String sFrameName)
					throws InterruptedException {
		WebDriverWait wait = null;
		By loc = Utility.getLocator("or", sFrameName);
		try {
			waitForPageLoad(driver);
			//logger.info("Waiting and Switching to Frame by its Name " + sFrameName);
			wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(loc));
			//logger.info("Switched to Frame : " + sFrameName);
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			waitForPageLoad(driver);
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(loc));
		} catch (Exception e) {
			//logger.error("Error Occured while switching to frame " + sFrameName + e.getMessage());
			driver.switchTo().frame(sFrameName);
		}

	}
	
	//Wait Functions
	/**
	 * An expectation for checking if the given text is present in the specified
	 * element
	 * 
	 * @param driver
	 * @param element
	 * @param sText
	 */
	public static void waitFortextToBePresentInElement(WebDriver driver,
			final String ele, final String sText) {
		WebElement element = Utility.getElement(driver, "or", ele);
		
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(BaseTest.CONFIG.getProperty("timeOutInSeconds")));
		wait.until(ExpectedConditions.textToBePresentInElement(element, sText));
	}

	/**
	 * An expectation for checking if the given text is present in the element
	 * that matches the given locator.
	 * 
	 * @param driver
	 * @param locator
	 * @param sText
	 */
	public static void waitFortextToBePresentInElementLocated(WebDriver driver,
			By locator, final String sText) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(BaseTest.CONFIG.getProperty("timeOutInSeconds")));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,
				sText));
	}
	
	//Page Load
		/**
		 * Waits for Page Load via Java Script Ready State
		 * 
		 * @param driver
		 * @param iTimeOut
		 * @throws InterruptedException
		 */
		public static boolean waitForPageLoad(WebDriver driver)
				throws InterruptedException {
			boolean isLoaded = false;
			int iTimeOut = Integer.parseInt(BaseTest.CONFIG.getProperty("timeOutInSeconds"));
			Thread.sleep(2000);
			try {
				//logger.info("Waiting For Page load via JS");
				ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript(
								"return document.readyState").equals("complete");
					}
				};
				WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
				wait.until(pageLoadCondition);
				isLoaded = true;
			} catch (Exception e) {
				//logger.error("Error Occured waiting for Page Load " + driver.getCurrentUrl());
			}
			return isLoaded;
		}

		/**
		 * Waits for Page Load via Java Script Ready State
		 * 
		 * @param driver
		 * @param iTimeOut
		 * @throws InterruptedException
		 */
		public static boolean waitForPageLoad(WebDriver driver, int iTimeOut)
				throws InterruptedException {
			boolean isLoaded = false;


			try {
				//logger.info("Waiting For Page load via JS");
				ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript(
								"return document.readyState").equals("complete");
					}
				};
				WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
				wait.until(pageLoadCondition);
				isLoaded = true;
			} catch (Exception e) {
				//logger.error("Error Occured waiting for Page Load " + driver.getCurrentUrl());
			}
			return isLoaded;
		}
	
	//Click Functions
	/**
	 * Performs click operation using JS
	 * 
	 * @param driver
	 * @param element
	 */
	public static void clickByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Performs Double Click on the Element using Action Class
	 * 
	 * @param driver
	 * @param element
	 */
	public static void doubleClick(WebDriver driver, WebElement element) {
		try {
			//logger.info("Double Click element via Action");
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			//logger.error("Error Occured while double clicking " + element);
		}
	}


	/**
	 * Performs Right Click on the Element using Action
	 * 
	 * @param driver
	 * @param element
	 */
	public static void rightClick(WebDriver driver, WebElement element) {
		try {
			//logger.info("Right Click on Element using Action Class");
			Actions action = new Actions(driver);
			//highlightElementBorder(driver, element);
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			//logger.error("Error Occured while right clicking " + element);
		}
	}
	
	//Hover Functions
	/**
	 * Move to the Element using coordinates
	 * 
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver, String ele) {
		WebElement element = Utility.getElement(driver, "or", ele);
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	/**
	 * mouse overs to an element and click specified.
	 * 
	 * @param driver
	 * @param Element
	 */
	public static void moveToElementAndClick(WebDriver driver,
			WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click().build().perform();
	}

	//Send Keys
	/**
	 * Waits and then sendkeys to element
	 * 
	 * @param driver
	 * @param element
	 * @param sValue
	 */
	public static void sendKeys(WebDriver driver, String ele,
			String sValue) {
		WebElement element;
		try {
			//WebElement element = Utility.getElement(driver, "or", ele);
			By loc = Utility.getLocator("or", ele);
			//logger.info("Waiting for an element to be clickable " + element);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(BaseTest.CONFIG.getProperty("timeOutInSeconds")));
			element = wait.until(ExpectedConditions.elementToBeClickable(loc));
			element.sendKeys(sValue);
			//logger.info("Waited and send value to on element " + element);
		} catch (Exception e) {
			//logger.info("Exception while supplying text to element" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Waits and then sendkeys to element
	 * 
	 * @param driver
	 * @param element
	 * @param sValue
	 */
	public static void sendKeys(WebDriver driver, String ele, String textChange, 
			String sValue) {
		WebElement element;
		try {
			//WebElement element = Utility.getElement(driver, "or", ele);
			By loc = Utility.getLocator("or", ele, textChange);
			//logger.info("Waiting for an element to be clickable " + element);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(BaseTest.CONFIG.getProperty("timeOutInSeconds")));
			element = wait.until(ExpectedConditions.elementToBeClickable(loc));
			element.sendKeys(sValue);
			//logger.info("Waited and send value to on element " + element);
		} catch (Exception e) {
			//logger.info("Exception while supplying text to element" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Input the text using JavaScript
	 * 
	 * @param driver
	 * @param element
	 * @param sData
	 * @throws InterruptedException 
	 */
	public static void sendKeysByJS(WebDriver driver, WebElement element,
			String sData) throws InterruptedException {
		Thread.sleep(750);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value=arguments[1];", element,
				sData);
	}
	
	//Element Display
	public static Boolean elementPresense(WebDriver driver, String element, String presence) {
		
		Boolean display = false;
		try {
			WebElement ele = Utility.getElement(driver, "or", element);
			display = ele.isDisplayed();
		
			Assert.assertTrue(display, element + " present on the page");
			if (display)
				ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed",element + " present on the page");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",element + " not present on the page");
			
		} catch(Exception e) {
			return false;
		}
		return display;
	}
	
	public static Boolean elementPresenseCheck(WebDriver driver, String element, String presence, int timeout) {
		Boolean display = false;
		try {
		WebElement ele = Utility.getElement(driver, "or", element, timeout);
		display = ele.isDisplayed();
		} catch(Exception e) {
			return false;
		}
		return display;
	}
	
	public static Boolean elementPresenseCheckCheckClass(WebDriver driver, String element, String presence, int timeout) {
		Boolean display = false;
		try {
			display = elementPresenseCheck(driver, element, presence, timeout);
			
			if(display) {
				if(readProperty(driver, element, "class").contains("hide")) {
					return false;
				}
				else
					return true;
					
			}
		} catch(Exception e) {
			return false;
		}
		return display;
	}
	
	//select
	/**
	* Selects a particular WebElement from the Select . It can be used when
	* HTML have Select <Option> DOM
	*
	* @param lstElementList
	* @param sValueToBeSelected
	*/
	public static void selectFromList(WebDriver driver, String selectObject, String textChange,
			String sValueToBeSelected) {
		try {
			WebElement select = Utility.getElement(driver, "or", selectObject, textChange);
			//logger.info("Inside getElementFromList method");
			List<WebElement> options = select
					.findElements(By.tagName("option"));
			//logger.info("Total elements having Option TAG :" + options.size());
			for (WebElement option : options) {
				//logger.info(option.getText());
				if (option.getText().trim()
						.equalsIgnoreCase(sValueToBeSelected.trim())) {
					//logger.info("Tag Name matched and will be clicked");
					option.click();
					break;
				}

			}
		} catch (Exception e) {
			//logger.error("Error ocurred while selecting the element fron List"
				//	+ e.getMessage());
			e.printStackTrace();
		}

	}
}
