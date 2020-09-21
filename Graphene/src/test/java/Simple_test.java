import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;

@RunWith(Arquillian.class)

public class Simple_test {
	//WebDriver firefox  = new FirefoxDriver();
	@Drone
	WebDriver browser;
	
	//WebDriver webdriver = new FirefoxDriver();;
    
	@Test
    
    public void testOpeningHomePage() {
    	
		// Maximize the browser window
		//driver.manage().window().maximize();
		
		browser.get("http://www.google.com");
        String pageTitle = browser.getTitle();
        Assert.assertEquals(pageTitle, "Google");

    	System.out.print("OK");
    }
}


