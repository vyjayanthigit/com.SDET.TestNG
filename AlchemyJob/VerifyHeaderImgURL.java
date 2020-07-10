package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHeaderImgURL {
	
	WebDriver gekDriver;
	
	//@BeforeMethod
	@BeforeTest
	public void lauchApplication() {
		
		gekDriver = new FirefoxDriver();
		gekDriver.get("https://alchemy.hguy.co/jobs/");
				
	}

    @Test
    public void verifyHeadingURL() {
    	
    	WebElement headingString = gekDriver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
    	System.out.println(headingString.getAttribute("src"));
    }
	
	@AfterMethod
	//@AfterTest
	 public void afterMethod() {
		
		System.out.println("into Aftermethod");
		//Close the browser
		gekDriver.quit();
	}
	
	

}
