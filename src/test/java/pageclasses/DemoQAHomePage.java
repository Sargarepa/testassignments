package pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHomePage extends PageObject {

	private static final Logger log = LogManager.getLogger(DemoQAHomePage.class.getName());
	
	@FindBy(xpath = "//h5[text()='Interactions']")
	private WebElement interactions;
	
	public DemoQAHomePage(WebDriver driver) {
		super(driver);
		log.info("At page: " + driver.getCurrentUrl());
	}
	
	public DemoQAInteractionsPage clickOnInteractions() {
		interactions.click();
		return new DemoQAInteractionsPage(driver);
	}
}
