package com.demoaut.newtours;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.FindFlightPage;

/**
 * Page Object Model
 * for NewTours LoginPage
 * http://newtours.demoaut.com/
 * 
 * Interfaces with the webpage
 * Enhances reusability of Selenium
 * 
 * @author Gigantor15
 *
 */
public class LoginPage {
	
	private final String usernameBoxName = "userName";
	private final String passwordBoxName = "password";
	private final String loginButtonName = "login";

	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		driver.get("http://newtours.demoaut.com/");
	}
	
	/**
	 * Types username keys into the username text box
	 * @param username
	 */
	public void setUsername(String username){
		driver.findElement(By.name(usernameBoxName)).sendKeys(username);
		implicitwait();
	}
	
	public void setPassword(String password){
		driver.findElement(By.name(passwordBoxName)).sendKeys(password);
		implicitwait();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public FindFlightPage clickLoginButton(){
		driver.findElement(By.name(loginButtonName)).click();
		implicitwait();
		return new FindFlightPage(driver);
	}
	
	public void implicitwait(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
