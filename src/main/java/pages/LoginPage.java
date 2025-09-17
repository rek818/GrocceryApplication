package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {

	public WebDriver driver;
	PageUtility pageUtility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility=new PageUtility();
	}

	@FindBy(name = "username")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement logintitle;

	public LoginPage enterUsernameOnUsernameField(String userName) {

		pageUtility.enterText(usernameField,userName);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		pageUtility.enterText(passwordField,password);
		return this;
	}

	public HomePage clickSigninButton() {
		pageUtility.clickElement(signinButton);
		return new HomePage(driver);
	}
//no need to apply chaining for below methods as they are for assertions
	public boolean isDashboardDisplayed() {
		return pageUtility.isElementDisplayed(dashboard);
	}

	public String getLoginText() {
		return pageUtility.getText(logintitle);
	}

}
