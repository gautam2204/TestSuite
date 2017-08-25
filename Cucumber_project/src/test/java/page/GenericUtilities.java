package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtilities {
	
	WebDriver driver;

	public void clickusingJS(WebElement elm) {
		try {
			elm.isDisplayed();

			elm.click();

		} catch (NoSuchElementException e) {
			throw e;
		}
	}

}
