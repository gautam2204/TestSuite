package page;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Login_Page extends GenericUtilities {

	public static WebDriver driver;

	public static final String defaultProp = "defaultProperties.properties";

	@FindBy(xpath = "html/body/nav/div/a[2]")
	WebElement SignIn;

	@FindBy(xpath = ".//*[@id='identifierId']")
	WebElement Input_Email;

	@FindBy(xpath = "(//*[contains(text(),'More options')])[2]")
	WebElement More_Options;

	@FindBy(xpath = "//*[contains(text(),'Enter your password')]")
	WebElement Enter_your_password;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Enter_password;
	
	@Before
	public void Before_TestRun()
	{
		System.out.println("Before Run ");
	}
	
	@After()
	public void After_TestRun() throws Exception
	{
		System.out.println("After Run ");
		driver.close();
		driver.quit();
		Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
	}

	public void verify_Sign_In_PageLoad(String url) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\java\\chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "src\\main\\java\\geckodriver.exe"); WebDriver driver = new
		 * FirefoxDriver();
		 */

		driver.navigate().to(GetProperty(url));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String heading = driver.findElement(By.xpath(".//h1")).getText().trim();
		Assert.assertEquals(
				"The ease & simplicity of Gmail, available across devices",
				heading);

	}

	/*
	 * Method for adding properties from property file
	 */

	public String GetProperty(String property) throws IOException {
		Properties prop = new Properties();
		// InputStream input =
		// Properties.class.getResourceAsStream(defaultProp);
		InputStream input = new FileInputStream(
				"E://cucumber Workspace//Cucumber_project//defaultProperties.properties");
		prop.load(input);
		return prop.getProperty(property);
	}

	public boolean isElementPresent(WebElement elm) {
		boolean flag = false;

		try {
			elm.isDisplayed();
			elm.isEnabled();

			flag = true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return flag;

	}

	public void clickSignIn() throws Exception {
		Thread.sleep(3000);
		System.out.println("driver" + driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("html/body/nav/div/a[2]")));
		element.click();

	}

	public void enter_EmailID(String username) throws IOException,
			InterruptedException {
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("identifierId")));
		element.click();
		if ((Character.isDigit(username.charAt(0)))) {
			element.sendKeys(username);
		} else {
			element.sendKeys(GetProperty(username));
		}
	}

	public void clickNext() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]"))
				.click();

	}

	public void enter_Password(String password) throws InterruptedException,
			Exception {
		// TODO Auto-generated method stub

		System.out.println("word");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@name='password']")));

		element.sendKeys(GetProperty(password));

	}

	public void verify_title() throws Exception {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("title" + driver.getTitle());
		int i = 1;
		do {
			Thread.sleep(1000);
			if (driver.getTitle().equalsIgnoreCase("Gmail")) {
				i++;
			} else {
				break;
			}
		} while (i <= 4);

		Assert.assertThat(driver.getTitle(),
				CoreMatchers.containsString("Inbox"));

	}

	public void error_message_display_wron_userId() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).getText(), "Enter a valid email or phone number");
		
	}

	public void enter_userID_credential_using_dataTable(DataTable table) {
		System.out.println("Table ==> "+table);
		
		List<List<String>> data = table.raw();
		System.out.println("check the data "+data.get(1).get(1));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("identifierId")));
		element.click();		
		element.sendKeys(data.get(1).get(0));
		
		
	}

	public void enter_password_credential_using_dataTable(DataTable table) throws InterruptedException {
		Thread.sleep(3000);
		
		List<List<String>> data = table.raw();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//input[@name='password']")));

		element.sendKeys(data.get(1).get(1));		
		
	}

	public void getallLinks() throws InterruptedException {
		
		List<WebElement> elm = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<elm.size();i++)
		{
		System.out.println("link "+(i+1)+" is "+elm.get(i).getAttribute("href"));
		String url = elm.get(i).getAttribute("href");
		
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.open('your url','_blank');");
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		System.out.println("number of tabs "+tabs.size());
		
		driver.switchTo().window(tabs.get(1));
		driver.navigate().to(url);
		Thread.sleep(3000);
		System.out.println("title of new tab "+driver.getTitle());
		
		if(!driver.getWindowHandle().equals(parentWindow))
		{
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		
	
		
		
		
		}
	}

}
