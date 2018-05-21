package project.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Login.qa.pages.ContactsPage;
import com.Login.qa.pages.HomePage;
import com.Login.qa.pages.LoginPage;
import Project.qa.util.TestUtil;
import ToolsQA.DemoMavenEclipseProject.TestBase;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";

	public ContactsPageTest(){
		super();	
	}
	@BeforeMethod
	  public void setUp() throws InterruptedException{
	  initialization();
	  testUtil=new TestUtil();
	  loginPage	= new LoginPage();
	  contactsPage=new ContactsPage();
	  homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	  testUtil.SwitchToFrame();
	  contactsPage=homepage.ClickOnContactLink();
	}
	@Test(priority=1,enabled=true)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");	
	}
	@Test(priority=2,enabled=true)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("Aary Chaudry");
	}
	@Test(priority=3,enabled=true)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("Aary Chaudry");
		contactsPage.selectContactsByName("Andrew Gomez");
		contactsPage.selectContactsByName("Armando Rameirz");
	}
	@DataProvider
	public Object[][]getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4,enabled=false,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company){
		homepage.ClickOnNewContactLink();	
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	  @AfterMethod
		 public void tearDown(){
		 driver.quit();
	}
}
