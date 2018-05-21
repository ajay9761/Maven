package com.Login.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ToolsQA.DemoMavenEclipseProject.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory-OR:
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page Objects:
	public LoginPage(){
	 PageFactory.initElements(driver,this);	
	}
	//Action:
	public String validateLoginPageTitle() throws InterruptedException{
	Thread.sleep(8000);
	 return driver.getTitle();
	}
	
	public boolean validateCRMImage() throws InterruptedException{
	Thread.sleep(3000);
	 return crmLogo.isDisplayed();
	}
			
	public HomePage login(String eml,String pwd) throws InterruptedException{
	 username.sendKeys(eml);
	 password.sendKeys(pwd);
	 Thread.sleep(4000);
	 loginBtn.click();
	 //Thread.sleep(8000);
	 return new HomePage();
	}	
}
