package com.karthikbandi.trainingprogram;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingStepsUsingLogFourJTest {

	// Initializing the logger
	static Logger log = Logger.getLogger(LoggingStepsUsingLogFourJTest.class);

	@Test
	public void testLogs() {
		log.info("Starting login test");

		log.info("Ending login test");
	}
}
