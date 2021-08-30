package pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResultsPage extends PageObject {
	
	private static final Logger log = LogManager.getLogger(GoogleResultsPage.class.getName());
	
	@FindBy(tagName = "h3")
	private WebElement firstResult;
	
	@FindBy(id = "result-stats")
	private WebElement resultStats;
	
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
		log.info("At page: " + driver.getCurrentUrl());
	}

	public DemoQAHomePage selectFirstResult() {
		wait.until(ExpectedConditions.visibilityOf(firstResult));
		firstResult.click();
		return new DemoQAHomePage(driver);
	}
	
	public int numberOfSearchResults() {
		//Wait for result stats to be visible
		wait.until(ExpectedConditions.visibilityOf(resultStats));
		
		//Find result stats text
		String resultStatsText = resultStats.getText();
		log.info("Result Stats Text = " + resultStatsText);
		
		//Extract number from result stats as a String
		String numberOfResultsString = resultStatsText.split(" ")[1].replace(".", "");
		int numberOfResults = Integer.parseInt(numberOfResultsString);
		log.info("Number of search results = " + numberOfResults);
		return numberOfResults;
	}
	
}
