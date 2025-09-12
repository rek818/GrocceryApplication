package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends TestNGBase {

	@Test(description="To verify whether user can successfully logout from the home page")
	public void verifyUserCanSuccessfullyLogout() throws IOException {
		
		
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		HomePage home = new HomePage(driver);
		
		home.clickOnAdmin();
		home.clickOnLogout();
		
		String expected="7rmart supermarket";
		String actual=home.getText();
		Assert.assertEquals(actual,expected,Constant.LOGOUTERROR);
		
		
		
	}

}
