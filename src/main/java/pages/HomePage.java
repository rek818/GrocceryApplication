package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	public WebDriver driver;
	PageUtility pageUtility;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageUtility=new PageUtility();
	}

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement title;
	@FindBy(xpath = "//p[text()='Admin Users']/ancestor::div/a[contains(text(),'More info')]")
	private WebElement moreInfo;
	@FindBy(xpath = "//p[text()='Manage News']/ancestor::div/a[contains(text(),'More info')]")

	private WebElement manageNewsPage;

	public HomePage clickOnAdmin() {
		admin.click();
		return this;
	}
	
	public LoginPage clickOnLogout() {
		logout.click();
		return new LoginPage(driver);
	}
	public ManageNewsPage goToManageNewsPage() {
		manageNewsPage.click();
		return new ManageNewsPage(driver);
	}
//assertion
	public String getText() {
		return title.getText();
	}
	public AdminUsersPage clickOnMoreInfo() {
		moreInfo.click();
		return new AdminUsersPage(driver);
	}
	

}
