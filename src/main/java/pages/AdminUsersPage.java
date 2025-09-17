package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageUtility;
	WaitUtility waitUtility;

	public AdminUsersPage(WebDriver driver)
	// TODO Auto-generated constructor stub
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility=new PageUtility();
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

	@FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(., 'User Created Successfully')]")
	private WebElement alertMessage;
	
	@FindBy(xpath="//*[@id='res' and contains(., 'RESULT NOT FOUND')]")
	private WebElement notFoundMessage;

	public AdminUsersPage clickOnNew() {
		pageUtility.clickElement(newUser);
		return this;

	}

	public AdminUsersPage enterUsernameOnUsernameField(String adminUserName) {
		pageUtility.enterText(username, adminUserName);
		return this;
	}

	public AdminUsersPage enterPasswordOnPasswordField(String adminPassword) {
		pageUtility.enterText(password, adminPassword);
		return this;

	}

	public AdminUsersPage selectUserType(int index) {
		pageUtility.selectDropdownWithIndex(userType,index);
		return this;
	}

	public AdminUsersPage clickOnSave() {
		pageUtility.clickElement(save);
		return this;
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchUser;

	@FindBy(name = "un")
	private WebElement usernameOnSearch;

	@FindBy(id = "ut")
	private WebElement userTypeOnSearch;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	private WebElement search;

	public AdminUsersPage clickOnSearch() {
		pageUtility.clickElement(searchUser);
		return this;

	}

	public AdminUsersPage enterUsernameOnSearchbox(String adminUserName) {
		pageUtility.enterText(usernameOnSearch, adminUserName);
		return this;
	}

	public AdminUsersPage selectUserTypeOnSearch(int index) {
		pageUtility.selectDropdownWithIndex(userTypeOnSearch, index);
		return this;
	}

	public AdminUsersPage clickOnSearchInsideSearch() {
		pageUtility.clickElement(search);
		return this;
	}

	//assertion
	public boolean isAlertMessageDisplayed() {
		return pageUtility.isElementDisplayed(alertMessage);
	}
	public boolean isNotFoundMessageDisplayed() {
	    try {
	        return pageUtility.isElementDisplayed(notFoundMessage);
	    } catch (NoSuchElementException e) {
	        return false; // Element not present → message is not displayed
	    }
	}



}
