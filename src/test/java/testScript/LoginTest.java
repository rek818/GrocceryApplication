package testScript;


import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test(priority=1,description="sucessful user login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {

		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test(priority=2)
	
	public void verifyLoginWithInValidUsernameValidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
	}
	@Test(priority=3)
	
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
	}
	@Test(priority=4)
	
	public void verifyLoginWithInValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(4, 0, "LoginPage");
		String password=ExcelUtility.getStringData(4, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
	}

}
