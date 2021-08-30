package com.matija.testassignments;

import java.io.IOException;

import org.junit.Test;

import pageclasses.DemoQAHomePage;
import pageclasses.DemoQAInteractionsPage;
import pageclasses.GoogleHomePage;
import pageclasses.GoogleResultsPage;
import utils.ScreenshotTaker;

public class Test1 extends FunctionalTest {

	@Test
	public void test1() throws InterruptedException, IOException {
		driver.get("https://www.google.com/");
		
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		
		GoogleResultsPage googleResultsPage = googleHomePage.searchAndSubmit("demoqa.com");
		
		DemoQAHomePage demoQAHomePage = googleResultsPage.selectFirstResult();
		
		DemoQAInteractionsPage demoQAInteractionsPage = demoQAHomePage.clickOnInteractions();
		
		demoQAInteractionsPage.clickDroppableButton();
		demoQAInteractionsPage.dragAndDrop();
		
		ScreenshotTaker.takeScreenShot(driver);
		
		demoQAInteractionsPage.clickWidgetsButton();
		demoQAInteractionsPage.clickToolTipsButton();
		demoQAInteractionsPage.mouseOverToolTipsTextField();
		demoQAInteractionsPage.logToolTipText();
		
	}

}
