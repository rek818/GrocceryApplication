package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver)
	// TODO Auto-generated constructor stub
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Admin Users']/ancestor::div/a[contains(text(),'More info')]")
	private WebElement moreInfo;

	public void clickOnMoreInfo() {
		moreInfo.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newUser;

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "user_type")
	private WebElement userType;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	private WebElement save;

	public void clickOnNew() {
		newUser.click();

	}

	public void enterUsernameOnUsernameField(String adminUserName) {
		username.sendKeys(adminUserName);
	}

	public void enterPasswordOnPasswordField(String adminPassword) {
		password.sendKeys(adminPassword);

	}

	public void selectUserType() {
		Select select = new Select(userType);
		select.selectByIndex(2);
	}

	public void clickOnSave() {
		save.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchUser;

	@FindBy(name = "un")
	private WebElement usernameOnSearch;

	@FindBy(id = "ut")
	private WebElement userTypeOnSearch;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	private WebElement search;

	public void clickOnSearch() {
		searchUser.click();

	}

	public void enterUsernameOnSearchbox(String adminUserName) {
		usernameOnSearch.sendKeys(adminUserName);
	}

	public void selectUserTypeOnSearch() {
		Select select = new Select(userTypeOnSearch);
		select.selectByIndex(2);
	}

	public void clickOnSearchInsideSearch() {
		search.click();
	}
}
