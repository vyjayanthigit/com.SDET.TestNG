package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateJobPosting {
	
   WebDriver gkDriver;
   
   @BeforeMethod
   public void createJob() throws Exception {
	   
	   gkDriver = new FirefoxDriver();
	   
	   gkDriver.get("https://alchemy.hguy.co/jobs");
   
	   Thread.sleep(1000);
   }
   
      
   @Test
   public void postJob() throws Exception {
	   
	   System.out.println("into postjob");
	   
	   WebElement postJobLink = gkDriver.findElement(By.xpath("//a[contains(text(),'Post a Job')]"));
	   
	   postJobLink.click();
	   
	   Thread.sleep(5000);
	   
	   
	   
   }
   @Test
   public void postJobUser() throws Exception {
	   
	   System.out.println("into post job user");
	   
	   WebElement emailEdit = gkDriver.findElement(By.id("create_account_email"));
	   
	   emailEdit.sendKeys("abc@yahoo.com");
	   
	   WebElement jobTitleEdit = gkDriver.findElement(By.id("job_title"));
	   
	   jobTitleEdit.sendKeys("Software Test Automation Developer");
	   
	   WebElement jobLocationEdit = gkDriver.findElement(By.id("job_location"));
	   
	   jobLocationEdit.sendKeys("Hyderabad");

	   WebElement jobTypeList = gkDriver.findElement(By.id("job_type"));
	   
	   Select slink = new Select(jobTypeList);
	   
	   slink.selectByValue("Internship");
	   
	   WebElement jobDescEdit = gkDriver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
	   
	   jobDescEdit.sendKeys("Good knowledge on Automation");
	   
	   WebElement appEmailEdit = gkDriver.findElement(By.id("application"));
	   
	   appEmailEdit.sendKeys("abc@yahoo.com");
	   
	   WebElement comNameEdit = gkDriver.findElement(By.id("company_name"));
	   
	   comNameEdit.sendKeys("Maveric System");
	   
	   WebElement previewButton = gkDriver.findElement(By.xpath("//input[@name='submit_job']"));
	   
	   previewButton.click();
	   
	   Thread.sleep(500);
	   
	   WebElement submitButton = gkDriver.findElement(By.xpath("//input[@name='continue']"));
	   
	   submitButton.click();
	   
	   Thread.sleep(500);
	   
	   WebElement confrmMsg = gkDriver.findElement(By.xpath("//div[@class='entry-content clear']"));
	   
	   String conMsg = confrmMsg.getText();
	   
	   System.out.println(conMsg);
	   
	   
 
   }
   
	@AfterMethod
	public void closeDriver() {
		
		gkDriver.quit();
		
	}

}
