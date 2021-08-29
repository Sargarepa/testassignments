package pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends PageObject {
	
	private static final Logger log = LogManager.getLogger(GoogleResultsPage.class.getName());
	
	@FindBy(tagName = "h3")
	private WebElement firstResult;
	
	@FindBy(id = "result-stats")
	private WebElement resultStats;
	
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
	
	public int numberOfSearchResults() {
		String resultStatsText = resultStats.getText();
		log.info("Result Stats Text = " + resultStatsText);
		String numberOfResultsString = resultStatsText.split(" ")[1].replace(".", "");
		int numberOfResults = Integer.parseInt(numberOfResultsString);
		log.info("Number of search results = " + numberOfResults);
		return numberOfResults;
	}
	
}
