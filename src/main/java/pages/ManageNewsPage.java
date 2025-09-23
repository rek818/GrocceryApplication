package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {

	public WebDriver driver;
	PageUtility pageUtility;

	public ManageNewsPage(WebDriver driver)
	// TODO Auto-generated constructor stub
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility = new PageUtility();
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement textbox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchNews;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchResultButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(className = "alert-success")
	private WebElement successMessage;
	@FindBy(xpath = "//*[@id='res' and contains(., 'RESULT NOT FOUND')]")
	private WebElement notFoundMessage;

	public ManageNewsPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleInsideTextBox(String newsTitle) {
		searchTextBox.sendKeys(newsTitle);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage clickOnSearch() {
		searchNews.click();
		return this;
	}

	public ManageNewsPage enterNewsTitlInsideSearchBox(String newsTitle) {
		searchTextBox.sendKeys(newsTitle);
		return this;
	}

	public ManageNewsPage clickOnSearchResultButton() {
		searchResultButton.click();
		return this;
	}

	public ManageNewsPage clickOnResetButton() {
		resetButton.click();
		return this;
	}
//assertion
	public boolean isNewsTitleSuccessMessageDispalyed() {
		return successMessage.isDisplayed();
	}

	public boolean isNotFoundMessageDisplayed() {
		try {
			return notFoundMessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false; // Element not present → message is not displayed
		}
	}

}
