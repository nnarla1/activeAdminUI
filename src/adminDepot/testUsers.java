package adminDepot;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Neelima Narla
 * @Date - 05/29/2018
 * @test Create valid user account and validate if User is created successfully!
 * @Framework - Junit 
 */

public class testUsers {
	
	WebDriver driver;
	
	String strOutput;
	
	String strChrDriver = "C:\\Users\\nnarla\\workspace\\activeAdminUI\\chromedriver.exe";
	String strAppUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin";
	String strUserLink = "//*[@id='users']/a";
	String strNewUserLink = "//*[@id='titlebar_right']/div/span/a";
	
	String strUserInput =  "//*[@id='user_username']";
	String strPwdInput =  "//*[@id='user_password']";
	String strEmailInput = "//*[@id='user_email']";
	String strCreateButton = "//*[@id='user_submit_action']/input";
	String strPageResult = "//*[@id='page_title']";
	
	@Before
	public void setUp() throws Exception {
		//Instantiate browser and navigate to URL
		System.out.println("****************************");
		System.out.println("launching Chrome browser....");
		
		System.setProperty("webdriver.chrome.driver", strChrDriver);
		driver = new ChromeDriver();
		System.out.println("Driver opened browser!");
		
		driver.get(strAppUrl);
		driver.manage().window().maximize();
		System.out.println("driver is able to navigate URL");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(strUserLink)).click();
		
		driver.findElement(By.xpath(strNewUserLink)).click();
		Thread.sleep(2000);
	}
		
	@Test
	public void test_Users() throws Exception {	
		//test01: Create user with valid values
		
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		
		String strUsername = ("actuser" + rand_int1);
		String strPassword = ("pwduser" + rand_int1);
		String stremail = (strUsername+"@sel.com");
		
		System.out.println("***************************************");
		System.out.println("test01:Create User");
		
		driver.findElement(By.xpath(strUserInput)).sendKeys(strUsername);
		System.out.println("Entered Username - " + strUsername);
		
		driver.findElement(By.xpath(strPwdInput)).sendKeys(strPassword);
		System.out.println("Entered Password - " + strPassword);
		
		driver.findElement(By.xpath(strEmailInput)).sendKeys(stremail);
		System.out.println("Entered email - " + stremail);
		
		driver.findElement(By.xpath(strCreateButton)).click();
		
		WebElement createUserResults  = driver.findElement(By.xpath(strPageResult));
		strOutput = createUserResults.getText();
		System.out.println("The User page title  = " + strOutput);
		Assert.assertEquals(strOutput, strUsername);
		
		System.out.println(strUsername + "user account is created successfully!");
		System.out.println("***************************************");
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	

}

