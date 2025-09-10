package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver)
	// TODO Auto-generated constructor stub
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage News']/ancestor::div/a[contains(text(),'More info')]")

	private WebElement manageNewsPage;
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
	@FindBy(className="alert-success")
	private WebElement successMessage;
	@FindBy(xpath="//*[@id='res' and contains(., 'RESULT NOT FOUND')]")
	private WebElement notFoundMessage;

	public void goToManageNewsPage() {
		manageNewsPage.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterNewsTitleInsideTextBox(String newsTitle) {
		textbox.sendKeys(newsTitle);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnSearch() {
		searchNews.click();
	}

	public void enterNewsTitlInsideSearchBox(String newsTitle) {
		searchTextBox.sendKeys(newsTitle);
	}

	public void clickOnSearchResultButton() {
		searchResultButton.click();
	}

	public void clickOnResetButton() {
		resetButton.click();
	}
	public boolean isNewsTitleSuccessMessageDispalyed()
	{
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
