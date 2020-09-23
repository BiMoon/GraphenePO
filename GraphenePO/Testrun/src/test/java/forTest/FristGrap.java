package forTest;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.junit.Test;
import testingpage.Homepage; //parkage name + classname 

@RunWith(Arquillian.class)
public class FristGrap {

	@Drone
	WebDriver browser;
	
	@Page Homepage homepage; 
	
	@Test
    
    public void testOpeningHomePage() {
	
		Homepage.geturl();
		
    }
	@Test
    
    public void search() {
	
		Homepage.search();
		
    }
}



