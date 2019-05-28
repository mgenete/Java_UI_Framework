package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	static Logger logger = Logger.getLogger(DriverFactory.class.getName());
	private String browser;
	public static Properties prop;
	
	
	public DriverFactory () {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utility\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver getDriver() {
		browser = prop.getProperty("browser");
		logger.info("# WebDriver instance for browser: " + browser);
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			return new ChromeDriver();
		
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			return new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/drivers/MicrosoftWebDriver.exe");
			return new EdgeDriver();
		}
	}
}
