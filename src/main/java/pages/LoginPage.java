package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement logintitle;

	public void enterUsernameOnUsernameField(String userName) {

		usernameField.sendKeys(userName);

	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSigninButton() {
		signin.click();
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public String getLoginText() {
		return logintitle.getText();
	}

}
