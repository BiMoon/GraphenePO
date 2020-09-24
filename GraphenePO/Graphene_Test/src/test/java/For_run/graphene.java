package For_run;


import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.junit.Test;


@RunWith(Arquillian.class)

public class graphene {

	@Drone
	WebDriver browser;

	@Test
    
    public void testOpeningHomePage() {
	
		browser.get("http://www.google.com");
        String pageTitle = browser.getTitle();
        Assert.assertEquals(pageTitle, "Google");
        System.out.print("page title " + pageTitle);
    }
}
