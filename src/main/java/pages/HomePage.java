package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']") 
	private WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;

	
	
	public void clickOnAdmin()
	{
		admin.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}

	}


