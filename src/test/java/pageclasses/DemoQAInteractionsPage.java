package pageclasses;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQAInteractionsPage extends PageObject {
	
	private static final Logger log = LogManager.getLogger(DemoQAInteractionsPage.class.getName());

	@FindBy(xpath = "//span[text()='Droppable']")
	private WebElement droppableButton;
	
	@FindBy(xpath = "//div[text()='Widgets']")
	private WebElement widgetsButton;
	
	@FindBy(xpath = "//span[text()='Tool Tips']")
	private WebElement toolTipsButton;
	
	@FindBy(id = "toolTipsTextField")
	private WebElement toolTipsTextField;
	
	@FindBy(xpath = "//div[@id='textFieldToolTip']/div[@class='tooltip-inner']")
	private WebElement textFieldToolTipText;
	
	@FindBy(id = "draggable")
	private WebElement draggable;
	
	@FindBy(id = "droppable")
	private WebElement droppable;
	
	public DemoQAInteractionsPage(WebDriver driver) {
		super(driver);
	}
	
	//Droppable button is not clickable because div[@id='fixedban'] obscures it so we click it using JavascriptExecutor
	//Same goes for other buttons
	public void clickDroppableButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", droppableButton);
	}
	
	public void clickWidgetsButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", widgetsButton);
	}
	
	public void clickToolTipsButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", toolTipsButton);
	}
	
	public void mouseOverToolTipsTextField() {
		Actions action = new Actions(driver);
		action.moveToElement(toolTipsTextField);
	}
	
	//For some reason getText() doesn't work on tool tip so we extract it using getAttribute("textContent")
	public void logToolTipText() {
		wait.until(ExpectedConditions.visibilityOf(textFieldToolTipText));
		String toolTipText = textFieldToolTipText.getAttribute("textContent");
		log.info("Tooltip text = " + toolTipText);
	}
	
	//Drag draggable to droppable
	public void dragAndDrop() {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();
	}
}
