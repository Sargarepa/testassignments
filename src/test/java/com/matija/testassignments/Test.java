package com.matija.testassignments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {

	private static final Logger log = LogManager.getLogger(Test.class.getName());
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AssignmentTestSuite.class);
		for (Failure failure : result.getFailures()) {
			log.info(failure.toString());
		}
		log.info(result.wasSuccessful());
	}

}
