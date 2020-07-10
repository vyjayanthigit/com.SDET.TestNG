package AlchemyJob;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class jobWPAdmin {
	
   WebDriver gkDriver;
   
   @BeforeMethod
   public void createJobAdmin() throws Exception {
	   
	   gkDriver = new FirefoxDriver();
	   
	   gkDriver.get("https://alchemy.hguy.co/jobs/wp-admin");
   
	   Thread.sleep(500);
   }
   
   
@Test
   public void loginJobWP() throws Exception {
	   
	   WebElement userLogin = gkDriver.findElement(By.id("user_login"));
	   WebElement userPassword = gkDriver.findElement(By.id("user_pass"));
	   	   
	   userLogin.sendKeys("root");
	   userPassword.sendKeys("pa$$w0rd");
	   
	   Thread.sleep(500);
	   
	   WebElement submitButton = gkDriver.findElement(By.id("wp-submit"));
	   submitButton.click();
	   
	   Thread.sleep(500);
	   
	   WebElement jobListingLink = gkDriver.findElement(By.xpath("//div[contains(text(),'Job Listings')]"));
	   
	    boolean checkConfirm = jobListingLink.isDisplayed();
       
       if(checkConfirm == true){
    	   System.out.println("jobListing Link displayed");
       }else {
    	   
    	   System.out.println("jobListing not available...");
    		 
       }
       
       Assert.assertTrue(checkConfirm);
       
 
   }
   
	@AfterMethod
	public void closeDriver() {
		
		gkDriver.quit();
		
	}

}
