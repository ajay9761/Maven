package com.Login.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ToolsQA.DemoMavenEclipseProject.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	@CacheLookup//Improve performance of script
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(text(),'Task')]")
	WebElement taskLink;
	
	//Initializing the page Objects:
	public HomePage(){
	 PageFactory.initElements(driver,this);	
	}
	public String verifyHomePageTitle() throws InterruptedException{
		Thread.sleep(3000);
	 return driver.getTitle();
	}
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	public ContactsPage ClickOnContactLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage ClickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
		
	}
	public TaskPage ClickOnTaskLink(){
		taskLink.click();
		return new TaskPage();
	}
		
		public void ClickOnNewContactLink(){
			Actions action =new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();
					
			
		}
}

