package testScript;


import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test(priority=1,description="sucessful user login with valid credentials",groups= {"smoke"},retryAnalyzer=retryAnalyzer.Retry.class)
	public void verifyLoginWithValidCredentials() throws IOException {

		String userName = ExcelUtility.getStringData(1, 10, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		boolean dashboardDisplay=login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay,Constant.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=2,description="user login with invalid username and valid password")
	
	public void verifyLoginWithInValidUsernameValidPassword() throws IOException
	{
		String userName= ExcelUtility.getIntegerData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		String expected="7rmrt supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDUSERNAMEERROR);
	}
	@Test(priority=3,description="user login with valid username and invalid password")
	
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getIntegerData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDCREDENTIALERROR);
		
	}
	@Test(priority=4,description="user login with invalid username and invalid password",groups= {"smoke"})
	
	public void verifyLoginWithInValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getIntegerData(4, 0, "LoginPage");
		String password=ExcelUtility.getIntegerData(4, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		String expected="7rmart supermarket";
		String actual=login.getLoginText();
		Assert.assertEquals(actual,expected,Constant.INVALIDCREDENTIALERROR);
		
		
	}

}
