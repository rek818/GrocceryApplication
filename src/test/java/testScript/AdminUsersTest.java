package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends TestNGBase {
	
	
	public void login() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test
	public void verifyAddAdminUsers() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		AdminUsersPage adminpage=new AdminUsersPage(driver);
		adminpage.clickOnMoreInfo();
		adminpage.clickOnNew();
		adminpage.enterUsernameOnUsernameField();
		adminpage.enterPasswordOnPasswordField();
		adminpage.clickOnSave();
		adminpage.clickOnReset();
	
	}
	@Test
	
	public void verifySearchAdminUsers() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		AdminUsersPage adminpage=new AdminUsersPage(driver);
		adminpage.clickOnMoreInfo();
		adminpage.clickOnSearch();
		adminpage.enterUsernameOnSearchbox();
		adminpage.selectUserTypeOnSearch();
		adminpage.clickOnSearchInsideSearch();
		adminpage.clickOnResetOnSearch();
		
	}
	
	
	

}
