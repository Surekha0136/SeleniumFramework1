/**
 * 
 */
package com.testyou.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testyou.pages.LoginPage;

import lib.ExcelDataConfig;

/**
 * @author Shankar_Kakde
 *
 */
public class VerifyTestyouLogin {
	WebDriver driver;

	@Test(dataProvider = "testyoudata")
	public void verifyValidLogin(String uid,String pass) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx");
		
		LoginPage login	= new LoginPage(driver);
		login.loginToTestyou(uid,pass);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Student"),"User is not able to login - Invalid credentials");
		System.out.println("Page title verified - user is able to login successfully");
		
		driver.quit();
	}	
/*	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
	
	@DataProvider(name="testyoudata")
	public Object[][] passData()
	{
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\shankar_kakde\\eclipse-workspace\\FrameworkProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		System.out.println("Total number of rows is "+rows);
		
     Object[][] data = new Object[rows][2];
     
     for(int i=0;i<rows;i++)
     {
    	 data[i][0]= config.getData(0,i, 0);
    	 data[i][1]= config.getData(0,i,1);
     }
     return data;
     
	}
		
}
