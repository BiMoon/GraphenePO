package test_run;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.junit.Test;
import Carreer_builder;

public class Graphene_run {
	@Drone
	WebDriver browser;
    @Page
    
    Carreer_builder homepage; 
    
	@Test
    
    public void testOpeningHomePage() {
    	

		//driver.manage().window().maximize();
		
		browser.get("http://www.google.com");
        String pageTitle = browser.getTitle();
        Assert.assertEquals(pageTitle, "Google");

    	System.out.print("OK");
    }
}

}
