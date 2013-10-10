package com.elsewhere_games.lib.logging;

// JUnit
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>Test case for the Log class.</p>
 */
public class LogTestCase {

	@Test
	public void createLog() {
		String logName = "test_log";

		// Create a log by name:
		Log log = LogManager.getInstance().getLog(logName);
		Assert.assertNotNull(log);
		Assert.assertTrue(log.getName().equals(logName));

		// Getting the log a second time should be the same log:
		Log copyOfLog = LogManager.getInstance().getLog(logName);
		Assert.assertEquals(log, copyOfLog);
	}

	@Test
	public void writeMessages() {

		// Create a log by name:
		String logName = "test_log";
		Log log = LogManager.getInstance().getLog(logName);

		// Set the level to the lowest possible, so all message go through:
		log.setLevel(Level.DEBUG);

		// Add an appender:
		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message.";

		log.error(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.ERROR, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		log.warn(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.WARN, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		log.info(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.INFO, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}

	@Test
	public void applyErrorLevel() {

		// Create a log by name:
		String logName = "test_log";
		Log log = LogManager.getInstance().getLog(logName);
		log.setLevel(Level.ERROR);

		// Add an appender:
		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message.";

		log.error(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.ERROR, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		// Message logged at other levels should not be received by the appender.

		appender.reset();
		log.warn(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.WARN, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));

		appender.reset();
		log.info(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.INFO, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));

		appender.reset();
		log.debug(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));
	}

	@Test
	public void applyWarningLevel() {

		// Create a log by name:
		String logName = "test_log";
		Log log = LogManager.getInstance().getLog(logName);
		log.setLevel(Level.WARN);

		// Add an appender:
		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message.";

		log.error(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.ERROR, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.warn(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.WARN, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		// Message logged at other levels should not be received by the appender.

		appender.reset();
		log.info(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.INFO, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));

		appender.reset();
		log.debug(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));
	}

	@Test
	public void applyInformationLevel() {

		// Create a log by name:
		String logName = "test_log";
		Log log = LogManager.getInstance().getLog(logName);
		log.setLevel(Level.INFO);

		// Add an appender:
		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message.";

		log.error(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.ERROR, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.warn(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.WARN, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.info(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.INFO, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		// Message logged at other levels should not be received by the appender.

		appender.reset();
		log.debug(message);

		Assert.assertNotEquals(log, appender.getLastSource());
		Assert.assertNotEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));
	}

	@Test
	public void applyDebugLevel() {

		// Create a log by name:
		String logName = "test_log";
		Log log = LogManager.getInstance().getLog(logName);
		log.setLevel(Level.DEBUG);

		// Add an appender:
		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message.";

		log.error(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.ERROR, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.warn(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.WARN, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.info(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.INFO, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));

		appender.reset();
		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}

}
