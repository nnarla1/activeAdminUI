package adminDepot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Neelima Narla
 * @date 05/29/18
 * @test Verify User search filters - "username", "email" 
 * @framework - 
 */

public class testUsersFilters {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/**
		 * define variables
		 */
		String userResults;
		String emailResults;
		String datePicker;
		String strUserValue = "user02";
		String stremailvalue = "user02@gmail.com";
		String strChDriver = "C:\\Users\\nnarla\\workspace\\mes_project\\chromedriver.exe";
		String strAppUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin";
		
		String strUserLink = "//*[@id='users']/a";
		String strddlUsername= "//*[@id='q_username_input']/select";
		String strUsername = "//*[@id='q_username']";
		String strddlEmail = "//*[@id='q_email_input']/select";
		String strEmail = "//*[@id='q_email']";
		String strFilterButton = "//*[@id='new_q']/div[4]/input[1]";
		String strClearButton = "//*[@id='new_q']/div[4]/a";
		
		//**************************************
		//Instantiate browser and navigate to URL
		System.out.println("*******************");
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", strChDriver);
		WebDriver driver = new ChromeDriver();
		System.out.println("opened browser");
		
		driver.get(strAppUrl);
		driver.manage().window().maximize();
		System.out.println("driver is able to open browser");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(strUserLink)).click();
		System.out.println("driver is able to click on the User Link");
		
		//*****************************************************
		//Filter Username results with given value- 'user02'
		
		for(int i=0; i<4; i++){
			
			Select userName  =  new Select(driver.findElement(By.xpath(strddlUsername)));
			List <WebElement> elementCount = userName.getOptions();
			
			String sValue = elementCount.get(i).getText();	
			System.out.println(sValue);
				
			userName.selectByVisibleText(sValue);
			//userName.selectByIndex(iSize);
				
			driver.findElement(By.xpath(strUsername)).sendKeys(strUserValue);
			Thread.sleep(2000);
				
			driver.findElement(By.xpath(strFilterButton)).click();
				
			userResults = driver.findElement(By.xpath("//*[@id='index_footer']/div[1]")).getText();
			System.out.println("When given " + strUserValue + " the filter results for " + sValue + " = " + userResults);
			Thread.sleep(1000);
				
			driver.findElement(By.xpath(strClearButton)).click();
			Thread.sleep(2000);
			
			}
		
		//*****************************************************
		//Filter email results with given value - 'user02@gmail.com'
			
		for(int i =0; i<4 ; i++){
					
			Select email  =  new Select(driver.findElement(By.xpath(strddlEmail)));
			List <WebElement> elementCount2 = email.getOptions();
			//int iSize = elementCount.size();
					
			String sValue2 = elementCount2.get(i).getText();	
			System.out.println(sValue2);
					
			email.selectByVisibleText(sValue2);
			//userName.selectByIndex(iSize);
					
			driver.findElement(By.xpath(strEmail)).sendKeys(stremailvalue);
			Thread.sleep(2000);
					
			driver.findElement(By.xpath(strFilterButton)).click();
					
			emailResults = driver.findElement(By.xpath("//*[@id='index_footer']/div[1]")).getText();
			System.out.println("When given " + stremailvalue + " the filter results for " + sValue2 + " = " + emailResults);
			Thread.sleep(1000);
					
			driver.findElement(By.xpath(strClearButton)).click();
			Thread.sleep(2000);
			
		//*****************************************************
		//Filter User results with datepicker 'created_at'Only
			
			driver.findElement(By.xpath("//*[@id='q_created_at_gteq_datetime']")).click();
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[3]/a"));
				
			}
			
		}

}
