package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLoginPage extends PageObject {

	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	public OrangeHRMLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public OrangeHRMDashboardPage clickLoginButton() {
		loginButton.click();
		return new OrangeHRMDashboardPage(driver);
	}

}
