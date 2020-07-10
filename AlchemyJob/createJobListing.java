package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class createJobListing {
	
   WebDriver gkDriver;
   
   @BeforeTest
   
   public void createJobAdmin() throws Exception {
	   
	   gkDriver = new FirefoxDriver();
	   
	   gkDriver.get("https://alchemy.hguy.co/jobs");
   
	   Thread.sleep(500);
   }
   
   
   
   @Test
   public void SearchJob() throws Exception {
	   
	   System.out.println("search job");
	   
	   WebElement jobLink = gkDriver.findElement(By.xpath("//li[@id='menu-item-24']//a[contains(text(),'Jobs')]"));
	   
	   jobLink.click();
	   
	   Thread.sleep(500);
	   
	   
	   
   }
   
   @Test
   public void jobPosting() throws Exception {
	   
	   System.out.println("this is job posting");
	   
	   WebElement searchEdit = gkDriver.findElement(By.id("search_keywords"));
	   
	   searchEdit.sendKeys("test");
	   
	   WebElement SearchButton = gkDriver.findElement(By.xpath("//div[@class='search_submit']//input"));
	   
	   SearchButton.click();
	   
	   WebDriverWait wait = new WebDriverWait(gkDriver, 100);
	   
	   wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//strong[contains(text(),'change')]")));
  
	   WebElement listJob = gkDriver.findElement(By.xpath("//strong[contains(text(),'change')]"));
	   
	   listJob.click();
	   
	   
	   Thread.sleep(500);
	   
	   wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@class='application_button button']")));
	   
	   WebElement applyButton = gkDriver.findElement(By.xpath("//input[@class='application_button button']"));
	   
	   applyButton.click();
	   
	   WebElement ConfirmMsg = gkDriver.findElement(By.xpath("//p[contains(text(),'To apply for this job')]"));
	   
	   boolean jobmsg =  ConfirmMsg.isDisplayed();
	   
	   Assert.assertTrue(jobmsg);
	   
	   Reporter.log("job confirmation message displayed "+ jobmsg);
   
	   
   }
   
	@AfterTest
	
	public void closeDriver() {
		
		gkDriver.quit();
		
	}

}
