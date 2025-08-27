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

	@FindBy(xpath = "//p[normalize-space()='Admin Users']/ancestor::div/a[normalize-space()='More info']")
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
		username.sendKeys("Rekha");
		password.sendKeys("rekha");

		Select select = new Select(userType);
		select.selectByIndex(2);
		save.click();

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchUser;
	
	@FindBy(name="un")
	private WebElement usernameOnSearch;

	@FindBy(id="ut")
	private WebElement userTypeOnSearch;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	private WebElement search;
	

	public void clickOnSearch() {
		searchUser.click();
		usernameOnSearch.sendKeys("Rekha");
		
		Select select=new Select(userTypeOnSearch);
		select.selectByIndex(2);
		
		search.click();
	}

}
