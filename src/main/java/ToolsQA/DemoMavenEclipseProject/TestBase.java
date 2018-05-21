package ToolsQA.DemoMavenEclipseProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import Project.qa.util.TestUtil;
import Project.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase(){
		try{	
	    prop = new Properties();
	    FileInputStream ip = new FileInputStream("C:\\Users\\TechproL-6\\workspace1\\DemoMavenEclipseProject\\src\\main\\java\\"
	    		+ "ProjectLogin\\qa\\config\\config.properties");
	    prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
		public static void initialization(){
		String browserName	= prop.getProperty("browser");
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		//Now create Event of EventListnerHandler to register it with EventFiring webDriver.
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1500, 900));	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//Also use this in single line.
		driver.get(prop.getProperty("url"));
	    System.out.println("Enter URL");
	}
}
   