package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Services;

public class InfiniteScrollPage extends Services{
	
	
	private final static String HEADING = "Infinite Scroll";
	private String xpathHeading = "//h3";

	private String xpathImage1 = "//div[@class='figure'][2]";
	private String xpathName1 = xpathImage1 + "//div[@class='figcaption']/h5";


	public InfiniteScrollPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void verifyInfiniteScrollPageHeader() {
		waitForElement(xpathHeading);
		WebElement header = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = header.getText();
		assertEquals(actualHeading, HEADING);
	}
	
	public void scrollVerticalPage() {
		String myScript = "window.scrollTo(0,document.body.scrollHeight)";
		((JavascriptExecutor)driver).executeScript(myScript);
	}
	
	public void scrollHorizontallyPage() {
		String myScript = "window.scrollBy(400,0)";
		((JavascriptExecutor)driver).executeScript(myScript);
	}
	
	
	public void scrollWithinParticularElement() {
		String myScript = "arguments[0].scrollIntoView();";
		WebElement element = driver.findElement(By.xpath("//td[@class='column-49' and text()='27.49']"));
		((JavascriptExecutor)driver).executeScript(myScript, element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
