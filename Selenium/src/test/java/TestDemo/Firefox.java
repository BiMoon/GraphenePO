package TestDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Firefox {
 
	
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		/**
		// Launch a new Firefox instance
		driver = new FirefoxDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Google
		driver.get("http://www.google.com");
		**/
		
		driver = Webdriver.getDriver("E");//"E" ->Test with Edge browser, "F" Firefox brower
	
	}
	
	
	@Test
	public void testGoogleSearch_new() throws IOException, Exception {
		// Find the text input element by its name
		//ReadTC.updateTestcaseName(tc_name);
		//String test_name = ReadTC.getTestcaseName(tc_name);
		/***
		if (null != test_name) {
			if (test_name.equals("N")){System.out.println("Test case NO need to be tested");return;}

		}
		else {ReadTC.updateTestcaseName(tc_name);}
		**/

		
		//final String tc_name = "TestGoogSeacch_For";
		String tc_name = new Throwable() 
		            .getStackTrace()[0] 
		            .getMethodName(); 

		System.out.println("Name of current method:" + tc_name);
		
		basicFunc.makestuffready(tc_name);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		// Clear the existing text value
		element.clear();
		// Enter something to search for
		element.sendKeys("Selenium testing tools cookbook");
		// Now submit the form
		element.submit();
		// Google's search is rendered dynamically with JavaScript.
		// wait for the page to load, timeout after 10 seconds
		new WebDriverWait(driver, 10).until(new	ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					//System.out.println("IM HERE");
					return d.getTitle().toLowerCase().startsWith("selenium JAVA testing");
				}
				
		});				
		
		String result = driver.getTitle();
		System.out.println(result);
		String build_id;
		ReadTC.updateTestReport(tc_name, "PASSED", build_id = basicFunc.getBuild_id());
		//call update test report
		
		}

	//@Test
	public void testGmailinvalidr() throws Exception {
		final String tc_name = "TestInvalidGmail_For";
		ReadTC.updateTestcaseName(tc_name);
		String test_name = ReadTC.getTestcaseName(tc_name);
		if (test_name.equals("Y")){ 
			System.out.println("Test case need to be tested");
			driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			// Find the text input element by its name
			WebElement username, pass, next_bt, login_bt;
			
			try {
				driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
				@SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
				WebElement message = wait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//*[@id=\"identifierId\"]"));
						}
						});
			} finally {
		
			username = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
			// Clear the existing text value
			username.clear();
			// Enter something to search for
			username.sendKeys("username");
			// Now submit the form
			next_bt = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
			next_bt.click();
			WebDriverWait wait = new WebDriverWait(driver, 15, 100);
			wait.until(ExpectedConditions.titleContains("Gmail"));
			assertNotEquals("Selenium testing tools cookbook - Google Search",driver.getTitle());
			
			}
		}
		else {System.out.println("Test case NO need to be tested");return;}
			//System.out.println("Test case NO need to be tested");
			//driver.close();
		String build_id;
		ReadTC.updateTestReport(tc_name, "PASSED", build_id = basicFunc.getBuild_id());
}
	@After
		public void tearDown() throws Exception {
		// Close the browser
		Thread.sleep(3);
		//driver.close();
		//Webdriver.quitDriver();
		
	}
}
