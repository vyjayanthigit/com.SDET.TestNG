package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifySecondHeading_h2 {
	
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
		
			
		WebElement secondHeadString = gekDriver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]"));
		
		System.out.println("the second header displayed or not :" + secondHeadString.isDisplayed());
		String headString = secondHeadString.getText();
		
		//chkHeading = headString.equals("Welcome to Alchemy Jobs");
		
		Assert.assertEquals(headString, "Quia quis non");
		
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
