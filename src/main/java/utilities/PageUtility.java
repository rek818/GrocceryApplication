package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}
	public void enterText(WebElement element, String value) {

		element.sendKeys(value);

	}
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public boolean isElementDisplayed(WebElement element)
	{
		
		return element.isDisplayed();
	}
	public String getText(WebElement element)
	{
		
		return element.getText();
	}
	

}
