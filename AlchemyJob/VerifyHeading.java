package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHeading {
	
	WebDriver gekDriver;
	
	//@BeforeMethod
	@BeforeTest
	public void lauchApplication() {
		
		gekDriver = new FirefoxDriver();
		gekDriver.get("https://alchemy.hguy.co/jobs/");
				
	}

	//second : Verify the website heading
	
	@Test
	
	public void verifyHeading() throws Exception {
		
		//boolean chkHeading;
		
		WebElement headingString = gekDriver.findElement(By.className("entry-title"));
		
		String headString = headingString.getText();
		
		//chkHeading = headString.equals("Welcome to Alchemy Jobs");
		
		Assert.assertEquals(headString, "Welcome to Alchemy Jobs");
		
		/*if(chkHeading == true){
			
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
		
		System.out.println("into Aftermethod");
		//Close the browser
		gekDriver.quit();
	}
	
	

}
