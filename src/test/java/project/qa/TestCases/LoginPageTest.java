package project.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Login.qa.pages.HomePage;
import com.Login.qa.pages.LoginPage;
import ToolsQA.DemoMavenEclipseProject.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest(){
		super();
	}
	
	 @BeforeMethod
	  public void setUp(){
		initialization();
	  loginPage	= new LoginPage();
	}
	 @Test(priority=1)
	 public void loginPageTitleTest() throws InterruptedException{
		String title = loginPage.validateLoginPageTitle();
		Thread.sleep(8000);
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	 }
	 @Test(priority=2)
	 public void crmLogoImageTest() throws InterruptedException{
		 boolean flag = loginPage.validateCRMImage();
		 Assert.assertTrue(flag);
	 }
	 @Test(priority=3)
	 public void loginTest() throws InterruptedException{
	    homepage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 }
	 
	 @AfterMethod
	 public void tearDown(){
	 driver.quit();
  }
}
