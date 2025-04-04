package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.extentlisteners.ExtentListeners;
import com.w2a.extentlisteners.ExtentManager;
import com.w2a.utilities.*;


public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static String browser;

	public Page() {

		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//resources//com//w2a//properties//log4j.properties");
		
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\w2a\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Jenkins Browser filter configuration
	if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			
			
			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
			

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			}else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			

		}
	}
	
	
	public static void quit(){
		
		driver.quit();
		
	}
	
	
	//Common Keywords
	public void click(String locator) {
	try {
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();		
		}else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}  
		}catch (Throwable t) {

			log.info("Error in clicking an element: "+locator);
			ExtentListeners.test.log(Status.INFO, "Error in clicking an element:" + locator);
			
		}
		}

	public static void type(String locator, String value) {
		try {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		}catch (Throwable t) {
			log.info("Error in typing in an element : "+locator+" value as : "+value);
			ExtentListeners.test.log(Status.INFO, "Error in typing in an element : " + locator + " value as " + value);
			
		}

	}
	
	static WebElement dropdown;

	public void select(String locator, String value)
	{
		try {
		if(locator.endsWith("_CSS"))
		{
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));		
		}else if(locator.endsWith("_XPATH"))
		{
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if(locator.endsWith("_ID"))
		{
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		}catch(Throwable t) {
		log.info("Error in Selecting from an element : "+locator+" value as : "+value);
		ExtentListeners.test.log(Status.INFO, "Error in Selecting from dropdown : " + locator + " value as " + value);
		}
	}

	public boolean isElementPresent(String locator) {

		try {
			if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator)));
			}
		} catch (Throwable t) {

			log.info("Element not found : " + locator);
			ExtentListeners.test.log(Status.INFO, "Element not found : " + locator);
			return false;

		}
		
		log.info("Finding an Element : " + locator);
		ExtentListeners.test.log(Status.INFO, "Finding an Element : " + locator);
		return true;
	}

	/*public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			ExtentManager.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + ExtentManager.fileName + "><img src=" + ExtentManager.fileName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, "Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(ExtentManager.fileName));

		}
	}*/
}
	

	