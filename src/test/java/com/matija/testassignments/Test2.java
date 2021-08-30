package com.matija.testassignments;

import static org.junit.Assert.*;

import org.junit.Test;

import pageclasses.GoogleHomePage;
import pageclasses.GoogleResultsPage;

public class Test2 extends FunctionalTest {

	@Test
	public void test2() {
		driver.get("https://www.google.com/");
		
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		
		GoogleResultsPage googleResultsPage = googleHomePage.searchAndSubmit("cheese");
		
		int numberOfSearchResults = googleResultsPage.numberOfSearchResults();
		
		assertTrue("There is too much cheese on the internet", 777 > numberOfSearchResults);
	}

}
