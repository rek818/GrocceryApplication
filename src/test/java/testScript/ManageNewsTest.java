package testScript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends TestNGBase {
	public HomePage homepage;

	@Test
	public void verifyWhetherUserIsAbleToAddNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		
		homepage=login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news = homepage.goToManageNewsPage();

//		String newsTitle=ExcelUtility.getStringData(1, 0, "NewsPage");
		RandomDataUtility random = new RandomDataUtility();
		String newsTitle = random.createRandomText();

		news.clickOnNewButton().enterNewsTitleInsideTextBox(newsTitle).clickOnSaveButton();

		boolean successMessageDisplay = news.isNewsTitleSuccessMessageDispalyed();
		Assert.assertTrue(successMessageDisplay, Constant.NEWSTITLENOTADDEDERROR);

	}

	@Test
	public void verifySearchForNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homepage = login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news = homepage.goToManageNewsPage();

		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		news.clickOnSearch().enterNewsTitlInsideSearchBox(newsTitle).clickOnSearchResultButton();
//assertion
		boolean notFoundMessageDisplay = news.isNotFoundMessageDisplayed();
		Assert.assertFalse(notFoundMessageDisplay, Constant.NEWSTITLENOTFOUNDERROR);
	}

	@Test
	public void verifyResetButtonFunctionality() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);

		homepage = login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news = homepage.goToManageNewsPage();
		news.clickOnResetButton();
	}

}
