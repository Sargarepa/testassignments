package pageclasses;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRMCandidatesPage extends PageObject {
	
	private static final Logger log = LogManager.getLogger(OrangeHRMCandidatesPage.class.getName());
	
	@FindBy(xpath = "//tr[@class = 'dataDefaultRaw dataRaw handCuser']")
	List<WebElement> candidatesList;
	
	@FindBy(id = "addItemBtn")
	WebElement addButton;
	
	@FindBy(id = "addCandidate_resume")
	WebElement resumeInputBox;
	
	@FindBy(id = "addCandidate_firstName")
	WebElement firstNameTextBox;
	
	@FindBy(id = "addCandidate_lastName")
	WebElement lastNameTextBox;
	
	@FindBy(id = "addCandidate_email")
	WebElement emailTextBox;
	
	@FindBy(id = "textarea_addCandidate_vacancy")
	WebElement vacancyDropDown;
	
	@FindBy(xpath = "//input[@class='employee-search validate' and @aria-invalid='false']")
	WebElement vacancyTextBox;
	
	//Element id changes with every load, very sneaky...
	@FindBy(xpath = "//ul[contains(@id, 'dropdownObjectSearch') and contains(@class, 'active')]//p")
	List<WebElement> vacancyOptions;
	
	@FindBy(xpath = "//li[@style='display: list-item;']")
	WebElement selectedVacancy;
	
	//Check container element for visibility before filling input fields
	@FindBy(id = "modalAddCandidate")
	WebElement formContainer;
	
	@FindBy(id = "saveCandidateButton")
	WebElement saveButton;
	
	@FindBy(xpath = "//tr[@class='dataDefaultRaw dataRaw handCuser' and position() = 1]//label")
	WebElement mostRecentCandidateCheckBox;
	
	@FindBy(id = "ohrmList_Menu")
	WebElement dropDownMenu;
	
	@FindBy(id = "deleteItemBtn")
	WebElement deleteButton;
	
	@FindBy(id = "modal-delete-candidate")
	WebElement deleteDialogueBox;
	
	@FindBy(id = "candidate-delete-button")
	WebElement confirmDeleteButton;
	
	@FindBy(id = "candidate-delete-cancel-button")
	WebElement cancelDeleteButton;
	
	public OrangeHRMCandidatesPage(WebDriver driver) {
		super(driver);
		log.info("At page: " + driver.getCurrentUrl());
	}
	
	//Most of the elements needed are in 'noncoreIframe' iframe
	public void switchToIframe() {
		driver.switchTo().frame("noncoreIframe");
	}
	
	//Switching back to default content once done with elements in iframe
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	//Wait for list to be displayed and for toast to disappear before calculating number of candidates
	public int numberOfCandidates() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row content']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		int numberOfCandidates = candidatesList.size();
		log.info("Number of candidates = " + numberOfCandidates);
		return numberOfCandidates;
	}
	
	public void clickOnAddItemButton() {
		wait.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
	}
	
	//Wait for container element to be visible before interacting with form elements
	public void addResume(String path) {
		wait.until(ExpectedConditions.visibilityOf(formContainer));
		resumeInputBox.sendKeys(path);
	}
	
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(formContainer));
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOf(formContainer));
		lastNameTextBox.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(formContainer));
		emailTextBox.sendKeys(email);
	}
	
	public void enterRandomVacancy() {
		wait.until(ExpectedConditions.visibilityOf(formContainer));
		vacancyDropDown.click();
		Random rand = new Random();
		int randomNumber = rand.nextInt(vacancyOptions.size() - 1) + 1;
		WebElement randomVacancy = vacancyOptions.get(randomNumber);
		randomVacancy.click();
	}
	
	public void saveCandidate() {
		wait.until(ExpectedConditions.visibilityOf(formContainer)).click();
		saveButton.click();
	}
	
	public void selectMostRecentCandidate() {
		mostRecentCandidateCheckBox.click();
	}
	
	public void clickOnDropDownMenu() {
		dropDownMenu.click();
	}
	
	public void clickOnDeleteButton() {
		deleteButton.click();
	}
	
	//Select confirm dialogue option and wait for toast to appear
	public void confirmDelete() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(deleteDialogueBox));
		confirmDeleteButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	}
}
