package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//Abstract class to avoid making objects of it
public abstract class PageObject {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

}
