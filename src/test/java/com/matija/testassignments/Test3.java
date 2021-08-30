package com.matija.testassignments;

import static org.junit.Assert.*;


import org.junit.Test;

import pageclasses.OrangeHRMCandidatesPage;
import pageclasses.OrangeHRMDashboardPage;
import pageclasses.OrangeHRMLoginPage;
import utils.Utils;

public class Test3 extends FunctionalTest {

	@Test
	public void test() throws InterruptedException {
		driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
		
		OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
		
		//Click login
		OrangeHRMDashboardPage dashboardPage = loginPage.clickLoginButton();
		
		//Wait for widgets to appear
		dashboardPage.waitForDashboardToLoad();
		
		//Clicks recruit button then clicks candidates button
		OrangeHRMCandidatesPage candidatesPage = dashboardPage.navigateToCandidatesPage();
		
		//Switch to iframe
		candidatesPage.switchToIframe();
		
		//Find number of candidates before adding
		int numberOfCandidatesBeforeAdding = candidatesPage.numberOfCandidates();
		
		candidatesPage.clickOnAddItemButton();
		
		//Add candidate
		String resumePath = System.getProperty("user.dir") + "\\resources\\CV.txt";
		candidatesPage.addResume(resumePath);
		candidatesPage.enterFirstName("QA Automation");
		candidatesPage.enterLastName(Utils.getCurrentDate());
		candidatesPage.enterEmail("test@email.com");
		candidatesPage.enterRandomVacancy();
		candidatesPage.saveCandidate();
		
		//Find number of candidates after adding
		int numberOfCandidatesAfterAdding = candidatesPage.numberOfCandidates();
		
		//Assert difference is 1
		int difference = numberOfCandidatesAfterAdding - numberOfCandidatesBeforeAdding;
		assertTrue("Difference after adding is = " + difference, numberOfCandidatesAfterAdding - numberOfCandidatesBeforeAdding == 1);
		
		//Delete recently added candidate
		candidatesPage.selectMostRecentCandidate();
		candidatesPage.clickOnDropDownMenu();
		candidatesPage.clickOnDeleteButton();
		candidatesPage.confirmDelete();
		
		//Find number of candidates after deleting
		int numberOfCandidatesAfterDeleting = candidatesPage.numberOfCandidates();
		
		//Assert difference is 1
		difference = numberOfCandidatesAfterAdding - numberOfCandidatesAfterDeleting;
		assertTrue("Difference after deleting is = " + difference, difference == 1);
		
		//Switch back from iframe
		candidatesPage.switchToDefaultContent();
	}

}
