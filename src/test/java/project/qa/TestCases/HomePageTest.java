package project.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Login.qa.pages.ContactsPage;
import com.Login.qa.pages.HomePage;
import com.Login.qa.pages.LoginPage;

import Project.qa.util.TestUtil;
import ToolsQA.DemoMavenEclipseProject.TestBase;


public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	//Test cases should be seperated & Independent with each other
	 @BeforeMethod
	  public void setUp() throws InterruptedException{
		initialization();
		testUtil=new TestUtil();
	  loginPage	= new LoginPage();
	  contactsPage=new ContactsPage();
	  homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	 @Test(priority=1,enabled=true)
	 public void verifyHomePageTitleTest() throws InterruptedException{
		String homePageTitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page title not matched");
	 }
	 @Test(priority=2,enabled=true)
	 public void verifyUserNameTest(){
		 testUtil.SwitchToFrame();
		 Assert.assertTrue(homepage.verifyCorrectUserName());
	 }
	 @Test(priority=3,enabled=true)
	 public void verifyContactsLinkTest(){
		 testUtil.SwitchToFrame();
		 contactsPage= homepage.ClickOnContactLink();
	
		 
	 }
	 
	 @AfterMethod
	 public void tearDown(){
	 driver.quit();
  }
}
