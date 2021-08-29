package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends PageObject {
	
	@FindBy(tagName = "h3")
	private WebElement firstResult;
	
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isInitialized() {
		return firstResult.isDisplayed();
	}
	
	//Selects first result after google searching for 'demoqa' and returns a DemoQAHomePage object, there has to be a way to make this more generic for different google searches
	public DemoQAHomePage selectFirstResult() {
		firstResult.click();
		return new DemoQAHomePage(driver);
	}
}
