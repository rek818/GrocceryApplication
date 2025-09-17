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
	HomePage homepage; 

	@Test(description="To verify whether user can successfully logout from the home page")
	public void verifyUserCanSuccessfullyLogout() throws IOException {
		
		
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		
		
		homepage=login.clickSigninButton();
		
		homepage.clickOnAdmin();
		login=homepage.clickOnLogout();
		
		String expected="7rmart supermarket";
		String actual=homepage.getText();
		Assert.assertEquals(actual,expected,Constant.LOGOUTERROR);
		
		
		
	}

}
