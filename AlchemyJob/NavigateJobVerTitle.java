package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateJobVerTitle {
	
	WebDriver gekDriver;
	
	//@BeforeMethod
	@BeforeTest
	public void lauchApplication() {
		
		gekDriver = new FirefoxDriver();
		gekDriver.get("https://alchemy.hguy.co/jobs/");
				
	}

	
	@Test
	
	public void navigateVerifyTitle() throws Exception {
		
			
		WebElement jobButton = gekDriver.findElement(By.id("menu-item-24"));
		
		jobButton.click();
		
		Thread.sleep(500);
		
		String jobTitle = gekDriver.getTitle();
		
		System.out.println("Job page title is :" + jobTitle);
				
		//chkHeading = headString.equals("Welcome to Alchemy Jobs");
		
		Assert.assertEquals(jobTitle, "Jobs – Alchemy Jobs");
		
				
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
