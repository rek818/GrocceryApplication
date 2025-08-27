package testScript;


import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {

	@Test
	public void verifyLoginWithValidCredentials() throws IOException {

//		WebElement usernameField = driver.findElement(By.name("username"));
//		usernameField.sendKeys("admin");
//		WebElement passwordField = driver.findElement(By.name("password"));
//		passwordField.sendKeys("admin");
//
//		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
//
//		signinButton.click();

		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test
	
	public void verifyLoginWithInValidUsernameValidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
	}
	@Test
	
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String userName= ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
	}
	@Test
	
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
