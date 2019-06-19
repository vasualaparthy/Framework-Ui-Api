package tests;

import java.util.HashMap;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.utility.SeleniumFunctions;
import com.framework.utils.excelutils.ExcelUtil;
import com.framework.utils.extentreports.ExtentTestManager;
import com.framework.utils.listeners.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

	HashMap<String, HashMap<String, String>> hashMapTestParam = new HashMap<String, HashMap<String, String>>();
	HashMap<String, String> hashMap = new HashMap<String, String>();
	
    @BeforeGroups("LoginData")
    public void setupTestCaseInfo() {
    		System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
        
        ExcelUtil.hashMapTestData = ExcelUtil.fetchTestCaseInformation();
    }
	
	@BeforeTest
    public void setupTestData () {
        //Set Test Data Excel and Sheet
        
    }

    @Test (priority = 0, description="Verify Sprint Chat Survey", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify Sprint Chat Survey")
    @Story("Verify Sprint Chat Survey")
    public void verifyChatSurvey () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Verify Sprint Chat Survey";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Sprint HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(!homePage.checkSignOutPresent()) {
        	homePage.goToLoginPage();
        	
        	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        }
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);
        
        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.verifyMessageAppear(10, hashMap.get("Message2"));
        
        homePage.endChat();
        
        homePage.switchDefaultContent();
        Thread.sleep(5000);
        Boolean status = homePage.switchToWindow(hashMap.get("WindowTitle"));
        
        if(status) {
        	homePage.validateSurveyForm();
        	//driver.close();
            homePage.switchToWindow(hashMap.get("WindowTitle2"));
        }
        
        
        homePage.switchDefaultContent();
    }

    @Test (priority = 0, description="Airvave Magic Box Support", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Airvave Magic Box Support")
    @Story("Airvave Magic Box Support")
    public void verifyAirvaveMagicBoxSupport () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Airwave Magic Box Support";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterQuestion(hashMap.get("Question1"), hashMap.get("Button1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption1"), hashMap.get("Message2"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button2"), hashMap.get("Message3"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button3"), hashMap.get("Message4"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message5"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button4"), hashMap.get("Message6"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button5"), hashMap.get("Message7"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message8"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }

    @Test (priority = 0, description="Coverage Area Issue", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Coverage Area Issue")
    @Story("Coverage Area Issue")
    public void verifyCoverageAreaIssue () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Coverage Area Issue";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message3"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button2"), hashMap.get("Message4"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption3"), hashMap.get("Message5"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message6"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }

    @Test (priority = 0, description="New Discount Request", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: New Discount Request")
    @Story("New Discount Request")
    public void verifyNewDiscountRequest () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "New Discount Request";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));  
        
        homePage.radioOptionSelect(hashMap.get("RadioOption3"), hashMap.get("Message3"));  
        
        //homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message3"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message4"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }

    @Test (priority = 0, description="Account Number Inquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Account Number Inquiry")
    @Story("Account Number Enquiry")
    public void verifyAccountNumberInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Account Number Enquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));  
        
        
        homePage.verifyMessageAppear(20, hashMap.get("Message3"));
        
        homePage.endChat();
        
        homePage.switchDefaultContent();
        
    }
 
    @Test (priority = 0, description="Wifi Inquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Wifi Inquiry")
    @Story("Wifi Inquiry")
    public void verifyWifiInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Wifi Inquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));  
        
        
        homePage.verifyMessageAppear(20, hashMap.get("Message3"));
        
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }

    @Test (priority = 0, description="Next Bill Inquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Next Bill Inquiry")
    @Story("Next Bill Inquiry")
    public void verifyNextBillInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Next Bill Inquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterOnly(hashMap.get("Question1"));
        
        homePage.verifyMessageAppear(30, hashMap.get("Message1"));
        
        homePage.endChat();
        
        homePage.switchDefaultContent();
        
    }


    @Test (priority = 0, description="Add Hotspot Service", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Add Hotspot Service")
    @Story("Add Hotspot Service")
    public void verifyAddHotspotService () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "Add Hotspot Service";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption3"), hashMap.get("Message3"));
        
        //homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message4"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message4"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }


    @Test (priority = 0, description="UC 11 Data Inquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: UC 11 Data Inquiry")
    @Story("UC 11 Data Inquiry")
    public void verifyUC11DataInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "UC 11 Data Inquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption3"), hashMap.get("Message3"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption4"), hashMap.get("Message4"));
        
        //homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message4"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message5"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }


    @Test (priority = 0, description="UC 07 AdjustmentsCreditInquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: UC 07 AdjustmentsCreditInquiry")
    @Story("UC 07 AdjustmentsCreditInquiry")
    public void verifyUC07AdjustmentsCreditInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "UC 07 AdjustmentsCreditInquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        //homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message2"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button2"), hashMap.get("Message3"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message4"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }


    @Test (priority = 0, description="UC18ChangeofOwnershipTransferofLiabilityInquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: UC18ChangeofOwnershipTransferofLiabilityInquiry")
    @Story("UC18ChangeofOwnershipTransferofLiabilityInquiry")
    public void UC18ChangeofOwnershipTransferofLiabilityInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "UC18ChangeofOwnershipTransferofLiabilityInquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message3"));
        
        
        homePage.verifyMessageAppear(20, hashMap.get("Message4"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }

    @Test (priority = 0, description="UC29DeviceUnlockInquiry", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: UC29DeviceUnlockInquiry")
    @Story("UC29DeviceUnlockInquiry")
    public void UC29DeviceUnlockInquiry () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "UC29DeviceUnlockInquiry";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadio(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        //homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        //homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message3"));
        
        
        homePage.verifyMessageAppear(20, hashMap.get("Message2"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }
   
    @Test (priority = 0, description="UC39SecurityPinAuthorizedUserChange", groups = "LoginData")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: UC39SecurityPinAuthorizedUserChange")
    @Story("UC39SecurityPinAuthorizedUserChange")
    public void UC39SecurityPinAuthorizedUserChange () throws InterruptedException {
        //extentreports Description
    		String testCaseName = "UC39SecurityPinAuthorizedUserChange";
    		hashMap = ExcelUtil.hashMapTestData.get(testCaseName);
    		
        ExtentTestManager.getTest().setDescription(testCaseName);

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToSprint(hashMap.get("Environment"));
        System.out.println("Homepage launched succesfully");
        //Go to LoginPage
        if(homePage.checkSignOutPresent()) {
        	SeleniumFunctions.click(driver, "signOutButtonClass");
        }
        homePage.goToLoginPage();
    	
    	loginPage.loginToSprint(hashMap.get("Username"), hashMap.get("Password"));
        
        System.out.println("Login to Dashboard succesfully");
        int rowNumber = Integer.parseInt(hashMap.get("RowNumber"));
        //Login to N11 with first row of the login data
        

        //Set test row number to 1
        ExcelUtil.setRowNumber(rowNumber);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(Integer.parseInt(hashMap.get("StatusColumnNumber")));

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        //loginPage.verifyLoginPassword(hashMap.get("Password Error"));
        homePage.navigatetoOrderReturn();
        
        homePage.openChatWindowEnterRadioInfo(hashMap.get("Question1"), hashMap.get("RadioOption1"), hashMap.get("Message1"));
        
        homePage.radioOptionSelect(hashMap.get("RadioOption2"), hashMap.get("Message2"));
        
        //homePage.radioOptionSelect(hashMap.get("RadioOption3"), hashMap.get("Message3"));
        
        //homePage.chooseQuestionYesNo(hashMap.get("Button1"), hashMap.get("Message3"));
        
        homePage.verifyMessageAppear(20, hashMap.get("Message3"));
        
        homePage.endChat(hashMap.get("WindowTitle"));
        
        homePage.switchDefaultContent();
        
    }
    

}
