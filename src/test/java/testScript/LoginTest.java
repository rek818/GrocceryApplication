package testScript;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	public HomePage homepage;
	
	@DataProvider(name="loginData")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][]
				{
			
				{ExcelUtility.getStringData(1,0 ,"LoginPage"),
				ExcelUtility.getStringData(1,1 ,"LoginPage")}
				
	};
	}


	@Test(priority=1,description="sucessful user login with valid credentials",groups= {"smoke"},dataProvider="loginData")
	public void verifyLoginWithValidCredentials(String userName,String password) throws IOException {

//		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
//		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
//		login.enterUsernameOnUsernameField(userName);
//		login.enterPasswordOnPasswordField(password);
//		login.clickSigninButton();
		
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homepage=login.clickSigninButton();//to get the control of driver to homepage
		
		boolean dashboardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay,Constant.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=2,description="user login with invalid username and valid password",retryAnalyzer=retryAnalyzer.Retry.class)
	
	public void verifyLoginWithInValidUsernameValidPassword() throws IOException
	{
		String userName= String.valueOf(ExcelUtility.getIntegerData(2, 0, "LoginPage"));
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password).clickSigninButton();
		
		
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDUSERNAMEERROR);
	}
	@Test(priority=3,description="user login with valid username and invalid password")
	
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=String.valueOf(ExcelUtility.getIntegerData(3, 1, "LoginPage"));
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password).clickSigninButton();
		
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDCREDENTIALERROR);
		
	}
	@Test(priority=4,description="user login with invalid username and invalid password",groups= {"smoke"})
	
	public void verifyLoginWithInValidUsernameInvalidPassword() throws IOException
	{
		String userName=String.valueOf( ExcelUtility.getIntegerData(4, 0, "LoginPage"));
		String password=String.valueOf(ExcelUtility.getIntegerData(4, 1, "LoginPage"));
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password).clickSigninButton();
		
		
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDCREDENTIALERROR);
		
		
	}

}
