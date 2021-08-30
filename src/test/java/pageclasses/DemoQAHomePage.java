package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHomePage extends PageObject {

	@FindBy(xpath = "//h5[text()='Interactions']")
	private WebElement interactions;
	
	public DemoQAHomePage(WebDriver driver) {
		super(driver);
	}
	
	public DemoQAInteractionsPage clickOnInteractions() {
		interactions.click();
		return new DemoQAInteractionsPage(driver);
	}
}
