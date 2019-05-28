package utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Init extends DriverFactory{
	
	static Logger logger = Logger.getLogger(Init.class.getName());
	protected WebDriver driver = null;
	
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() {
		logger.info("# Setup.");
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		logger.info("# Teardown.");
		if(driver != null)
			driver.quit();
	}

}
