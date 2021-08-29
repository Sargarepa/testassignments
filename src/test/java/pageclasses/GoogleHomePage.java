package pageclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends PageObject {
	
	
	@FindBy(name = "q")
	private WebElement search;

	public GoogleHomePage(WebDriver driver) {
		
		super(driver);
	}
	
	@Override
	public boolean isInitialized() {
		return search.isDisplayed();
	}
	
	//Enter query into search box
	public void enterSearchQuery(String query) {
		search.clear();
		search.sendKeys(query);
	}
	
	public GoogleResultsPage submit() {
		search.sendKeys(Keys.ENTER);
		return new GoogleResultsPage(driver);
	}
	
	public GoogleResultsPage searchAndSubmit(String query) {
		enterSearchQuery(query);
		return submit();
	}
	
}
