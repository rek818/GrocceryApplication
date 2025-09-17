package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends TestNGBase {

	public HomePage homepage;

	@Test(priority = 1, description = "To verify add a new user inside AdminUsers page")
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homepage = login.clickSigninButton();

		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage = homepage.clickOnMoreInfo();

		

		RandomDataUtility random = new RandomDataUtility();
		String adminUserName = random.createRandomUsername();
		String adminPassword = random.createRandomPassword();
		adminpage.clickOnNew().enterUsernameOnUsernameField(adminUserName).enterPasswordOnPasswordField(adminPassword).selectUserType(2).clickOnSave();
//assertion
		boolean alertDisplay = adminpage.isAlertMessageDisplayed();

		Assert.assertTrue(alertDisplay, Constant.USERNOTADDEDERROR);

	}

	@Test(priority = 2, description = "To verify the search of an added user inside AdminUsers page")

	public void verifyUserIsAbleToSearchNewUser() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homepage=login.clickSigninButton();

		String adminUserName = ExcelUtility.getStringData(1, 0, "AdminUsersPage");

		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage = homepage.clickOnMoreInfo().clickOnSearch().enterUsernameOnSearchbox(adminUserName).selectUserTypeOnSearch(2).clickOnSearchInsideSearch();

		//assertion
		boolean notFoundMessageDisplay = adminpage.isNotFoundMessageDisplayed();
		Assert.assertFalse(notFoundMessageDisplay, Constant.USERNOTFOUNDERROR);

	}

}
