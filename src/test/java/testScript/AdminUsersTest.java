package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends TestNGBase {

	@Test(priority = 1, description = "To verify add a new user inside AdminUsers page")
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

//		String adminUserName = ExcelUtility.getStringData(1, 0, "AdminUsersPage");
//		String adminPassword = ExcelUtility.getStringData(1, 1, "AdminUsersPage");

		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnMoreInfo();
		adminpage.clickOnNew();

		RandomDataUtility random = new RandomDataUtility();
		String adminUserName = random.createRandomUsername();
		String adminPassword = random.createRandomPassword();
		adminpage.enterUsernameOnUsernameField(adminUserName);
		adminpage.enterPasswordOnPasswordField(adminPassword);
		adminpage.selectUserType();
		adminpage.clickOnSave();

		boolean alertDisplay = adminpage.isAlertMessageDisplayed();

		Assert.assertTrue(alertDisplay, Constant.USERNOTADDEDERROR);

	}

	@Test(priority = 2, description = "To verify the search of an added user inside AdminUsers page")

	public void verifyUserIsAbleToSearchNewUser() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		String adminUserName = ExcelUtility.getStringData(1, 0, "AdminUsersPage");

		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnMoreInfo();
		adminpage.clickOnSearch();
		adminpage.enterUsernameOnSearchbox(adminUserName);
		adminpage.selectUserTypeOnSearch();
		adminpage.clickOnSearchInsideSearch();
		
		boolean notFoundMessageDisplay=adminpage.isNotFoundMessageDisplayed();
		Assert.assertFalse(notFoundMessageDisplay, Constant.USERNOTFOUNDERROR);
		

	}

}
