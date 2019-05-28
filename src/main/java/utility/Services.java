package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Services {
	
	static Logger logger = Logger.getLogger(Services.class.getName());
	protected WebDriver driver;
	
	
	public Services(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public void waitForElement(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForElementVisible(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForElementInvisible(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}
	
	public boolean isElementPresent(String locator) {
		try {
			driver.findElement(By.xpath(locator));
			return true;
			
		} catch (NoSuchElementException  e) {
			return false;
		}
	}
	
	
	public void assertElementPresentByXpath(String locator) {
		logger.info("# Verifying element.");
		Assert.assertTrue(isElementPresent(locator), "Element " + locator + " is found.");
	}
	
	
	public void assertAndClick(String locator) {
		assertElementPresentByXpath(locator);
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	public void assertAndType(String locator, String text) {
		assertElementPresentByXpath(locator);
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public boolean isElementVisisble(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void assertElementVisisble(String locator, boolean isVisible) {
		logger.info("# Verifying element visibility.");
		if(isVisible)
			Assert.assertTrue(isElementPresent(locator), "Element " + locator + " is visible");
		else
			Assert.assertFalse(isElementVisisble(locator), "Element " + locator + " is not visible");
	}
	
}
