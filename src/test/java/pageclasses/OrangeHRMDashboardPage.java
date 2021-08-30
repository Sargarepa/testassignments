package pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMDashboardPage extends PageObject {
	
	private static final Logger log = LogManager.getLogger(OrangeHRMDashboardPage.class.getName());
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentButton;
	
	@FindBy(id = "menu_recruitment_viewCandidates")
	WebElement candidatesButton;
	
	
	public OrangeHRMDashboardPage(WebDriver driver) {
		super(driver);
		log.info("At page: " + driver.getCurrentUrl());
	}
	
	//Wait for widgets to load
	public void waitForDashboardToLoad() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("widget.id")));
	}
	
	public void clickRecruitmentButton() {
		recruitmentButton.click();
	}
	
	public OrangeHRMCandidatesPage clickCandidatesButton() {
		candidatesButton.click();
		return new OrangeHRMCandidatesPage(driver);
	}
	
	//Navigate to candidates page by clicking recruitment tab and selecting candidates from it
	public OrangeHRMCandidatesPage navigateToCandidatesPage() {
		clickRecruitmentButton();
		return clickCandidatesButton();
	}

}
