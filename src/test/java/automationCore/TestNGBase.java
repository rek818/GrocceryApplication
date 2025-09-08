package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenShotUtility;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenShotUtility screenShot = new ScreenShotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}
