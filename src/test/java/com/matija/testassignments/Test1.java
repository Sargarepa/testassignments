package com.matija.testassignments;

import static org.junit.Assert.*;

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
		assertTrue(googleHomePage.isInitialized());
		
		GoogleResultsPage googleResultsPage = googleHomePage.searchAndSubmit("demoqa.com");
		assertTrue(googleResultsPage.isInitialized());
		
		DemoQAHomePage demoQAHomePage = googleResultsPage.selectFirstResult();
		assertTrue(demoQAHomePage.isInitialized());
		
		DemoQAInteractionsPage demoQAInteractionsPage = demoQAHomePage.clickOnInteractions();
		assertTrue(demoQAInteractionsPage.isInitialized());
		
		demoQAInteractionsPage.clickDroppableButton();
		demoQAInteractionsPage.dragAndDrop();
		
		ScreenshotTaker.takeScreenShot(driver);
		
		demoQAInteractionsPage.clickWidgetsButton();
		demoQAInteractionsPage.clickToolTipsButton();
		demoQAInteractionsPage.mouseOverToolTipsTextField();
		demoQAInteractionsPage.logToolTipText();
		
	}

}
