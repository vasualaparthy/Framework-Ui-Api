package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.utility.SeleniumFunctions;
import com.framework.utility.Utility;

import io.qameta.allure.Step;
import tests.BaseTest;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    String baseURL = BaseTest.CONFIG.getProperty("testsiteURL");


    //*********Page Methods*********

    //Go to Homepage
    @Step("Open Sprint Step...")
    public void goToSprint (String env){
    	
    	switch(env) {
    		case "Prod" :
    			baseURL = BaseTest.CONFIG.getProperty("prodURL");
    			break;
    		case "St1" :
    			baseURL = BaseTest.CONFIG.getProperty("st1URL");
    			break;
    		case "St2" :
    			baseURL = BaseTest.CONFIG.getProperty("st2URL");
    			break;
    		default:
    			baseURL = BaseTest.CONFIG.getProperty("prodURL");
    			break;
    	}
    	
    	
        driver.get(baseURL);
        
        SeleniumFunctions.elementPresense(driver, "pageTitleSprint", "Displayed");
        //driver.navigate().to(baseURL)
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public void goToLoginPage (){
        click(Utility.getLocator("or", "signInButtonClass"));
        
        SeleniumFunctions.elementPresense(driver, "signInPageTile", "Displayed");
    }
    
    @Step("Go to Sign Out Button Step...")
    public Boolean checkSignOutPresent (){
        Boolean present = false;
        try {
        switchDefaultContent();	
        	
        present = SeleniumFunctions.elementPresenseCheckCheckClass(driver, "signOutButtonClass", "Displayed", 8);
        
        SeleniumFunctions.waitAndSwitchToFrame(driver, 2, "inqChatStage");
		System.out.println("Switch to chat frame");
		
		boolean presentChat = SeleniumFunctions.elementPresenseCheck(driver, "chatWindowEnd", "Displayed", 2);
		System.out.println("Finding Chat End button");
		
		if (presentChat) {
			SeleniumFunctions.click(driver, "chatWindowEnd");
			System.out.println("Click on Chat End button");
		}
        
        switchDefaultContent();
        } catch  (Exception e) {
        	e.printStackTrace();
        	switchDefaultContent();
        	return false;
        }
        
        return present;
    }

    @Step("Go to Order Return Page Step...")
	public void navigatetoOrderReturn() {
    	Boolean status = false;
    	System.out.println("Moving to Element - My Sprint");
		SeleniumFunctions.moveToElement(driver, "pageTitleSprint");
		
		status = SeleniumFunctions.elementPresenseCheck(driver, "orderTransFerLink", "Displayed", 15);
		System.out.println("Order Transfer link found" + status);
		
		click(Utility.getLocator("or", "orderTransFerLink"));
		System.out.println("Order Transfer link clicked succesfully");
		
		status = SeleniumFunctions.elementPresense(driver, "orderTransferHeader", "Displayed");
		System.out.println("Order Transfer Page opened succesfully " + status);
		
		click(Utility.getLocator("or", "orderReturnKitLink"));
		System.out.println("Order Return Kit link clicked succesfully");
		
		status = SeleniumFunctions.elementPresense(driver, "orderReturnHeading", "Displayed");
		System.out.println("Order Return Page opened succesfully " + status);
		
		status = SeleniumFunctions.elementPresense(driver, "chatWindow", "Displayed");
		System.out.println("Chat Window appear succesfully " + status);
		
		
	}

	public void enterInfoInChatWindow() {
		//Switching to frame
		try {
			SeleniumFunctions.waitAndSwitchToFrame(driver, 10, "inqChatStage");
			System.out.println("Switch to chat frame");
			
			SeleniumFunctions.sendKeys(driver, "chatFotterInput", "i want to change my address");
			System.out.println("Value entered inchat frame");
			
			Thread.sleep(5000);
			SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Hello, and thanks for chatting with Sprint!", "Chat window appear with msg: ");
			System.out.println("Chat msg appear");
			
			SeleniumFunctions.click(driver, "chatFotterSendMsg");
			System.out.println("Click on Send Message option");
			
			SeleniumFunctions.click(driver, "chatSelectOptionRadio", "Subscriber");
			System.out.println("Click on Subscriber option");
			
			SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Which address do you want to change - billing or subscriber?", "Chat window appear with msg: ");
			System.out.println("Chat msg appear");
			
			SeleniumFunctions.click(driver, "chatButtonContinue");
			System.out.println("Click on Continue button");
			
			SeleniumFunctions.sendKeys(driver, "chatSelectOptionInput", "Address", "1119 Mckinley Ave");
			System.out.println("Value entered in Address field");
			
			//SeleniumFunctions.sendKeys(driver, "chatSelectOptionInput", "Apt./Suite");
			//System.out.println("Value entered in Apt./Suite field");
			
			SeleniumFunctions.sendKeys(driver, "chatSelectOptionInput", "City", "Oakland");
			System.out.println("Value entered in City field");
			
			SeleniumFunctions.selectFromList(driver, "chatSelectOptionSelect", "State", "California");
			System.out.println("Value selected in State field");
			
			SeleniumFunctions.sendKeys(driver, "chatSelectOptionInput", "ZIP code", "94610");
			System.out.println("Value entered in ZIP code field");
			
			SeleniumFunctions.click(driver, "chatButtonContinue");
			System.out.println("Click on Continue button");
			
			//Cura: Here's what you entered for your address.

			//1119 McKinley Ave Oakland CA 94610

			//Is this correct?

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void openChatWindowEnterOnly(String Question1) {
		
		try {
		click(Utility.getLocator("or", "chatWindow"));
		System.out.println("Chat Window clicked succesfully ");
		
		SeleniumFunctions.waitAndSwitchToFrame(driver, 10, "inqChatStage");
		System.out.println("Switch to chat frame");
		
		SeleniumFunctions.sendKeys(driver, "chatFotterInput", Question1);
		System.out.println("Value entered inchat frame");
		
		Thread.sleep(5000);
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Hello, and thanks for chatting with Sprint!","Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatFotterSendMsg");
		System.out.println("Click on Send Message option");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openChatWindowEnterRadio(String Question1, String RadioOption1, String Message1) {
		
		try {
		click(Utility.getLocator("or", "chatWindow"));
		System.out.println("Chat Window clicked succesfully ");
		
		SeleniumFunctions.waitAndSwitchToFrame(driver, 10, "inqChatStage");
		System.out.println("Switch to chat frame");
		
		SeleniumFunctions.sendKeys(driver, "chatFotterInput", Question1);
		System.out.println("Value entered inchat frame");
		
		Thread.sleep(5000);
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Hello, and thanks for chatting with Sprint!", "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatFotterSendMsg");
		System.out.println("Click on Send Message option");
		
		SeleniumFunctions.click(driver, "chatSelectOptionRadio", RadioOption1);
		System.out.println("Click on "+ RadioOption1 + " option");
		
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", Message1, "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatButtonContinue");
		System.out.println("Click on Continue button");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void openChatWindowEnterRadioInfo(String Question1, String RadioOption1, String Message1) {
		
		try {
		click(Utility.getLocator("or", "chatWindow"));
		System.out.println("Chat Window clicked succesfully ");
		
		SeleniumFunctions.waitAndSwitchToFrame(driver, 10, "inqChatStage");
		System.out.println("Switch to chat frame");
		
		SeleniumFunctions.sendKeys(driver, "chatFotterInput", Question1);
		System.out.println("Value entered inchat frame");
		
		Thread.sleep(5000);
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Hello, and thanks for chatting with Sprint!", "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatFotterSendMsg");
		System.out.println("Click on Send Message option");
		
		SeleniumFunctions.click(driver, "chatSelectOptionRadioInfo", RadioOption1);
		System.out.println("Click on "+ RadioOption1 + " option");
		
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", Message1, "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatButtonContinue");
		System.out.println("Click on Continue button");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
    public void openChatWindowEnterQuestion(String Question1, String Button1, String Message1) {
		
		try {
		click(Utility.getLocator("or", "chatWindow"));
		System.out.println("Chat Window clicked succesfully ");
		
		SeleniumFunctions.waitAndSwitchToFrame(driver, 10, "inqChatStage");
		System.out.println("Switch to chat frame");
		
		SeleniumFunctions.sendKeys(driver, "chatFotterInput", Question1);
		System.out.println("Value entered inchat frame");
		
		Thread.sleep(5000);
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", "Hello, and thanks for chatting with Sprint!", "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		SeleniumFunctions.click(driver, "chatFotterSendMsg");
		System.out.println("Click on Send Message option");
		
		String questionElem = "chatButtonYes";
		if(Button1.equalsIgnoreCase("No"))
			questionElem = "chatButtonNo";
		
		SeleniumFunctions.click(driver, questionElem);
		System.out.println("Click on "+ Button1 + " button");
		
		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", Message1, "Chat window appear with msg: ");
		System.out.println("Chat msg appear");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public void radioOptionSelect(String radioOption, String message) {
    	try {
    		System.out.println("Option " + radioOption + " Msg: " + message);
    		SeleniumFunctions.click(driver, "chatSelectOptionRadio", radioOption);
    		System.out.println("Click on "+ radioOption + " option");
    		
    		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", message, "Chat window appear with msg: ");
    		System.out.println("Chat msg appear");
    		
    		SeleniumFunctions.click(driver, "chatButtonContinue");
    		System.out.println("Click on Continue button");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void radioInfoOptionSelect(String radioOption, String message) {
    	try {
    		System.out.println("Option " + radioOption + " Msg: " + message);
    		SeleniumFunctions.click(driver, "chatSelectOptionRadioInfo", radioOption);
    		System.out.println("Click on "+ radioOption + " option");
    		
    		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", message, "Chat window appear with msg: ");
    		System.out.println("Chat msg appear");
    		
    		SeleniumFunctions.click(driver, "chatButtonContinue");
    		System.out.println("Click on Continue button");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void chooseQuestionYesNo(String questionYesNo, String message) {
    	try {
    		System.out.println("Option " + questionYesNo + " Msg: " + message);
    		String questionElem = "chatButtonYes";
    		if(questionYesNo.equalsIgnoreCase("No"))
    			questionElem = "chatButtonNo";
    		
    		SeleniumFunctions.elementPresenseCheck(driver, questionElem, "Displayed", 20);
    		System.out.println("Click on "+ questionElem + " option");
    		
    		SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", message, "Chat window appear with msg: ");
    		System.out.println("Chat msg appear");
    		
    		SeleniumFunctions.click(driver, questionElem);
    		System.out.println("Click on "+ questionElem + " option");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	public void verifyMessageAppear(int timeout, String Message) {
		try {
			Thread.sleep(timeout * 1000);
			
			SeleniumFunctions.elementContainInfo(driver, "chatAgentMsg", Message, "Chat window appear with msg: ");
			System.out.println("Chat msg appear");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void endChat() {
		try {
			SeleniumFunctions.click(driver, "chatWindowEnd");
			System.out.println("Click on Chat End button");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void endChat(String windowTitle) {
		try {
			SeleniumFunctions.click(driver, "chatWindowEnd");
			System.out.println("Click on Chat End button");
			
			Thread.sleep(6000);
			
			//Boolean status = switchToWindowCheck(windowTitle);
			//if (status)
			//	driver.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void switchDefaultContent() {
		try {
			SeleniumFunctions.switchToDefault(driver);
			System.out.println("Switched to Parent Frame");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Boolean switchToWindow(String windowTitle) {
		try {
			
			Boolean status = SeleniumFunctions.switchToWindowHandle(driver, windowTitle);
			System.out.println("Switched to window " + windowTitle + " : " + status);
			
			Assert.assertTrue(status, "Window Found - " + windowTitle);
			return status;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean switchToWindowCheck(String windowTitle) {
		try {
			Boolean status = SeleniumFunctions.switchToWindowHandle(driver, windowTitle);
			System.out.println("Switched to window " + windowTitle);
			
			return status;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void validateSurveyForm() {
		try {
			System.out.println("Survey Form Appear");
			Thread.sleep(5000);
			Boolean status = false;
			status = SeleniumFunctions.elementPresense(driver, "sprintSurveyHeader", "Displayed");
			System.out.println("Survey Window appear succesfully " + status);
			
			status = SeleniumFunctions.elementPresense(driver, "sprintSurveyQuestion", "Displayed");
			System.out.println("Survey Window - Question appear succesfully " + status);
			
			status = SeleniumFunctions.elementPresense(driver, "sprintSurveyInput", "Displayed");
			System.out.println("Survey Window - Input appear succesfully " + status);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
