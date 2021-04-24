/**
 * 
 */
package com.testyou.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Shankar_Kakde
 *
 *This class will store all locators and methods of 
 *Login page
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	By username = By.id("ctl00_CPHContainer_txtUserLogin");
	By password = By.id("ctl00_CPHContainer_txtPassword");
	By loginButton = By.name("ctl00$CPHContainer$btnLoginn");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public void loginToTestyou(String uid,String pass)
	{
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();		
	}
	public void typeusername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	public void typepassword(String pwd) 
	{
	    driver.findElement(password).sendKeys(pwd);	
	}
	public void clickonLoginButton()
	{
	    driver.findElement(loginButton).click();
	}
	

}
