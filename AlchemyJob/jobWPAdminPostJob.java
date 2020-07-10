package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jobWPAdminPostJob {
	
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
	   
	   jobListingLink.click();
	   
	   Thread.sleep(500);
	   
	   WebElement newJobButton = gkDriver.findElement(By.xpath("//a[@class='page-title-action']"));
	   
	   newJobButton.click();
	   
	   Thread.sleep(500);
	   
	//close the panel
	   
	   WebElement alertClose = gkDriver.findElement(By.xpath("//div[@class='components-modal__header']//button[@class='components-button has-icon']//*[local-name()='svg']"));
	   
	   alertClose.click();
	   
	   Thread.sleep(500);
	   
	   gkDriver.findElement(By.id("post-title-0")).click();
	   
	   Thread.sleep(500);
	   
	   gkDriver.findElement(By.id("post-title-0")).sendKeys("Test Engineer");
	   
	   Thread.sleep(500);
	   
	   //gkDriver.findElement(By.id("block-4ee873cf-9ebb-4a1e-876c-41312d5a95e3")).click();
	   
	   //Thread.sleep(500);
	   
	   //gkDriver.findElement(By.xpath("//div[@id='editor-c012aebe-7a35-4f0f-ba66-2b1f8f94bd6e']//p)")).sendKeys("Test Automation Engineer");
	   
	   //Thread.sleep(300);
	   
	   JavascriptExecutor js = (JavascriptExecutor) gkDriver;
       js.executeScript("window.scrollBy(0,350)", "");
	   
       //Enter required values
       
       gkDriver.findElement(By.id("_application")).sendKeys("abhiram@cklabs.com");
       
       gkDriver.findElement(By.id("_company_website")).sendKeys("abc.com");
       
       gkDriver.findElement(By.id("_company_twitter")).sendKeys("@abcTwitter");
       
       gkDriver.findElement(By.id("_job_location")).sendKeys("Hyderabad");
       
       gkDriver.findElement(By.id("_company_name")).sendKeys("SomanthTechnologies");
       
      
       
       gkDriver.findElement(By.id("_company_tagline")).sendKeys("_company_tagline");
       
       gkDriver.findElement(By.id("_featured")).click();
       
       System.out.println( gkDriver.findElement(By.id("_featured")).isSelected());
       
     //button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']
       
       gkDriver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']")).click();
       
       Thread.sleep(500);
       
       gkDriver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")).click();
       												   
       Thread.sleep(500);
       
       WebElement confirmElement = gkDriver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-published']"));
       
       boolean checkConfirm = confirmElement.isDisplayed();
       
       if(checkConfirm == true){
    	   System.out.println("Confirmation message got displayed");
       }else {
    	   
    	   System.out.println("job not published....");
    		 
       }
       
       
 
   }
   
	@AfterMethod
	public void closeDriver() {
		
		gkDriver.quit();
		
	}

}
