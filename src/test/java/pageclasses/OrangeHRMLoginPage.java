package pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLoginPage extends PageObject {

	private static final Logger log = LogManager.getLogger(OrangeHRMLoginPage.class.getName());
	
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	public OrangeHRMLoginPage(WebDriver driver) {
		super(driver);
		log.info("At page: " + driver.getCurrentUrl());
	}
	
	//Click login button to navigate to dashboard page
	public OrangeHRMDashboardPage clickLoginButton() {
		loginButton.click();
		return new OrangeHRMDashboardPage(driver);
	}

}
