package AlchemyJob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadTitle {
	
	WebDriver gekDriver;
	
	//@BeforeMethod
	@BeforeTest
	public void lauchApplication() {
		
		gekDriver = new FirefoxDriver();
		gekDriver.get("https://alchemy.hguy.co/jobs/");
				
	}
	//first : Verify the website title
	@Test
	public void getTitle() throws Exception {
		
		boolean checkTitle;
		String sTitle = gekDriver.getTitle();
		
		System.out.println("The title of the page is:"+ sTitle);
		
		checkTitle = sTitle.equals("Alchemy Jobs – Job Board Application");
		Assert.assertTrue(checkTitle);

		
		//Assert.assertTrue(sTitle.equals("Alchemy Jobs – Job Board Application"));
		
		/*if(checkTitle == true){
		
			System.out.println("title is mathcing with the given string");
		}
		else {
			System.out.println("title is not matching with the given string");
		}*/
		
		Thread.sleep(500);
	}
	

	@AfterMethod
	//@AfterTest
	 public void afterMethod() {
		System.out.println("into After Method");
		//Close the browser
		gekDriver.quit();
	}
	
	

}
