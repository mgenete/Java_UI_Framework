package pageObjects;

import org.openqa.selenium.WebDriver;

import utility.Services;

public class LargeDeepDOMPage extends Services{
	
	static final String FOLLOWING_SIBLINGS_XPATH =
            "//div[@id='sibling-1.2']/following-sibling::div[not(contains(@class,'parent'))]";
    static final String PRECEDING_SIBLINGS_XPATH =
            "//div[@id='sibling-1.3']/preceding-sibling::div[not(contains(@class,'parent'))]";
    static final String PARENT_XPATH = "//div[@id='sibling-2.2']/parent::div";
    static final String ANCESTOR_XPATH =
            "//div[@id='sibling-2.2']/ancestor::div[contains(@id,'sib')]";
    static final String DOM_ELE_XPATH = "//div[text()='**dynamic**']";

	public LargeDeepDOMPage(WebDriver driver) {
		super(driver);
	}

}
