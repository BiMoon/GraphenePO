package testingpage;
import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {
	@Drone
    private static WebDriver browser;
	
	@FindBy(name = "q")
	private static WebElement search_input;

	static public void geturl() {
	browser.get("http://www.google.com");
    String pageTitle = browser.getTitle();
    Assert.assertEquals(pageTitle, "Google");
    System.out.print("page title " + pageTitle);
	}
	
	static public void search() {
		String key = "JAVA";
		
		search_input.clear();
		search_input.sendKeys(key);
		search_input.submit();
		System.out.print("Open " + key + " in CHROM");
		
		WebDriverWait wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.titleContains(key));
		String pageTitle = browser.getTitle();
		assertEquals(key, pageTitle);

	}
}
