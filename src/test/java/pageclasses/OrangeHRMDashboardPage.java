package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMDashboardPage extends PageObject {
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentButton;
	
	@FindBy(id = "menu_recruitment_viewCandidates")
	WebElement candidatesButton;
	
	
	public OrangeHRMDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForDashboardToLoad() {
		//Wait for widgets to load
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("widget.id")));
	}
	
	public void clickRecruitmentButton() {
		recruitmentButton.click();
	}
	
	public OrangeHRMCandidatesPage clickCandidatesButton() {
		candidatesButton.click();
		return new OrangeHRMCandidatesPage(driver);
	}
	
	public OrangeHRMCandidatesPage navigateToCandidatesPage() {
		clickRecruitmentButton();
		return clickCandidatesButton();
	}

}
