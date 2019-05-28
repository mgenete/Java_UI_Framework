package pageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Services;

public class AlertPage extends Services{
	
	static Logger logger = Logger.getLogger(AlertPage.class.getName());
	
	private final static String HEADING = "JavaScript Alerts";
	private static final String SUCCESS_MSG = "You successfuly clicked an alert";
	private static final String CANCEL_MSG = "You clicked: Cancel";
	private static final String HELLO_MSG = "You entered: Hello";
	private String xpathHeading = "//h3";
	private String xpathButtons = "//button[text()='**dummy**']";
	private String xpathResult = "//p[@id='result']";

	public AlertPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyAlertPageHeader() {
		waitForElement(xpathHeading);
		WebElement header = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = header.getText();
		logger.info("# Actual Heading: " + actualHeading);
		assertEquals(actualHeading, HEADING, "Actual heading '" + actualHeading + "' shall be same as expected '" + HEADING + "'.");
	}

	public void clickOnButton(String btn) {
		String xpath = xpathButtons.replace("**dummy**", btn);
		getWebElement(xpath).click();
	}
	
	public void accept() {
		Alert alert = driver.switchTo().alert();
		logger.info("# Text on alert: " + alert.getText());
		alert.accept();
		
		String actual = getWebElement(xpathResult).getText();
		Assert.assertEquals(actual, SUCCESS_MSG);
	}
	
	public void cancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String actual = getWebElement(xpathResult).getText();
		Assert.assertEquals(actual, CANCEL_MSG);
	}
	
	public void typeAndAccept() {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello");
		alert.accept();
		
		String actual = getWebElement(xpathResult).getText();
		Assert.assertEquals(actual, HELLO_MSG);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
