package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.TestNGBase;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends TestNGBase {

	@Test
	public void verifyWhetherUserIsAbleToAddNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.goToManageNewsPage();
		news.clickOnNewButton();
//		String newsTitle=ExcelUtility.getStringData(1, 0, "NewsPage");
		RandomDataUtility random = new RandomDataUtility();
		String newsTitle = random.createRandomText();

		news.enterNewsTitleInsideTextBox(newsTitle);
		news.clickOnSaveButton();
		
		boolean successMessageDisplay=news.isNewsTitleSuccessMessageDispalyed();
		Assert.assertTrue(successMessageDisplay,"The news title is not added successfully");

	}

	@Test
	public void verifySearchForNewNewsTitle() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.goToManageNewsPage();
		news.clickOnSearch();
		String newsTitle = ExcelUtility.getStringData(1, 0, "NewsPage");
		news.enterNewsTitlInsideSearchBox(newsTitle);
		news.clickOnSearchResultButton();
		
		boolean notFoundMessageDisplay=news.isNotFoundMessageDisplayed();
		Assert.assertFalse(notFoundMessageDisplay, "The news title is not found"); 
	}

	@Test
	public void verifyResetButtonFunctionality() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.goToManageNewsPage();
		news.clickOnResetButton();
	}

}
