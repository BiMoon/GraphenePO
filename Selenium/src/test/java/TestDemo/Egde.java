package TestDemo;
import static org.junit.Assert.*;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
public class Egde {
	private WebDriver driver;
	
	@FindBy(linkText = "Đăng nhập")
	private WebElement login;
	
	WebElement user, pass, next_bt, login_bt;  //login page
	WebElement fmame, lname, email, pass_confirm, reg_bt; // đăng ký page
	WebElement laguare;
	
	String fname_send = "lucky";
	String lname_send = "lucky";
	String email_send = "lucky.com@homeabc.com";
	String pass_send = "123456789";
	
	//public Egde(WebDriver driver) {PageFactory.initElements(driver,this);}
	@Before
	public void setUp() throws Exception {
		
		/**
		System.setProperty("webdriver.edge.driver","msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.setPageLoadStrategy("eager");
		// Launch a new Edge instance
		driver = new EdgeDriver(options);
		// Navigate to Google
		driver.get("http://gmail.com");
	
		**/
		driver = Webdriver.getDriver("F");
		driver.get("https://careerbuilder.vn/en");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		
		
		
		//driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
	}
	public Boolean careerbuilderLogin() {

		Boolean result = true;
		//login = driver.findElement(By.linkText("Đăng nhập"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		
		login.click();
		
		try {
		user = 	driver.findElement(By.xpath("//input[@name='username']"));
		pass = driver.findElement(By.xpath("//input[@name='password']"));
		user.sendKeys(email_send);
		pass.sendKeys(pass_send);
		
		
		} catch (NoSuchElementException e) {
		
		}
		login_bt = driver.findElement(By.xpath("//button[@type='submit']"));
		login_bt.submit();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		try {
			driver.findElement(By.className("hassuser"));
			System.out.print(" đăng nhập thành công" + "\n");
			result = true;
			
		} catch (NoSuchElementException e) {
		    System.out.print("Không thể đăng nhập" + "\n");
		    result = false;
		    }
		
		return result;
		
	}
	public Boolean careerbuilderRegister() {
		
		Boolean result = false;

		WebElement reg_link_text = driver.findElement(By.linkText("Đăng ký"));
		
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(reg_link_text));


		reg_link_text.click();
		System.out.print(" 'đăng ký' link should be CLIKED now" + "\n");
		System.out.print(" 'đăng ký' page should be SHOWED" + "\n");
		
		// wait for đăng ký page loaded
		
		reg_bt = driver.findElement(By.xpath("//button[@class='btn-gradient']"));
		WebDriverWait wait_reg = new WebDriverWait(driver, 15, 100);
		WebElement regElement = wait_reg.until(ExpectedConditions.elementToBeClickable(reg_bt)); //button submit is clickable
		System.out.print(" 'đăng ký' page is SHOWED" + "\n"); 
		// field form
		fmame = driver.findElement(By.xpath("//input[@id='firstname']"));
		lname= driver.findElement(By.xpath("//input[@id='lastname']"));
		email = driver.findElement(By.xpath("//input[@id='email']"));
		pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass_confirm = driver.findElement(By.xpath("//input[@id='confirm_password']"));
		System.out.print(" All elemnents are set" + "\n");
		
		fmame.sendKeys(fname_send);
		lname.sendKeys(lname_send);
		email.sendKeys(email_send);
		pass.sendKeys(pass_send);
		pass_confirm.sendKeys(pass_send);
		reg_bt.submit();
		
		//verify đăng ký thành công
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			driver.findElement(By.className("hassuser"));
			System.out.print(" đăng ký thành công" + "\n");
			result = true;
			
		} catch (NoSuchElementException e) {
		    System.out.print(email_send +" đã đăng ký" + "\n");
		    result = false;}
		return result;
	}
	

	
	public void careerbuilderRegisterTestFail() {

		Boolean result = careerbuilderRegister();
		
		assertTrue(!result);
 	}	

	public void careerbuilderRegisterTestOK() {

		Boolean result = careerbuilderRegister();
		
		assertTrue(result);
 	}
	@Test
	public void careerbuilderRegisterTestLoginPass() {

		Boolean result = careerbuilderLogin();
		
		assertTrue(result);
 	}

	
	public void careerbuilderRegisterTestLoginFail() {
		String temp_pass_send = pass_send;
		pass_send = "1234";
		
		Boolean result = careerbuilderLogin();
		
		pass_send = temp_pass_send;
		
		assertTrue(!result);
		
 	}


		// Find the text input element by its name
		/**
		username = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		// Clear the existing text value
		username.clear();
		// Enter something to search for
		username.sendKeys("username");
		// Now submit the form
		next_bt = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
		next_bt.click();
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		WebElement myElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]"))); 
		WebElement pass_element = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
		pass_element.sendKeys("passwork");
		pass_element.submit();
		// Google's search is rendered dynamically with JavaScript.
		// wait for the page to load, timeout after 10 seconds
		new WebDriverWait(driver, 10).until(new	ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
				}
				
		});
		assertNotEquals("Selenium testing tools cookbook - Google Search",driver.getTitle());
		
		System.out.println(driver.getTitle());
		**/
	
	@After
		public void tearDown() throws Exception {
		// Close the browser
		//driver.quit();
		//System.out.println(driver.getTitle());
	}
}
