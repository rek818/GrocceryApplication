package automationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase {
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {
//			driver=new FirefoxDriver();
		driver = new ChromeDriver();// open browser
//		driver=new EdgeDriver();
//			driver.get("https://selenium.qabible.in/");//open url
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");

		driver.manage().window().maximize();
	}

//	@AfterMethod
//	public void closeandquit()// close all the browsers
//	{
//
//		driver.quit();// close more than one browsers
//
//	}

}
