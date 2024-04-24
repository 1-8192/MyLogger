/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: TestSeverityFilterLogger.java
 * Description: Unit tests for the SeverityFilterLogger.
 */

package edu.bu.met.cs665;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the SeverityFilterLogger.
 */
public class TestSeverityFilterLogger {
  /**
   * Testing that the decorator works.
   */
  @Test
  public void testSeverityFilterLogger() {
    // Setting up classes and mocks we'll need.
    Logger mockLogger = mock(Logger.class);
    SeverityFilterLogger logger = new SeverityFilterLogger.Builder()
          .withLogger(mockLogger)
          .withMinSeverity(Level.ERROR)
          .build();

    logger.debug("Debug message");
    // The decorated logger should not log the message because the minimum severity is ERROR
    verify(mockLogger, never()).debug(anyString());

    logger.info("Info message");
    // The decorated logger should not log the message because the minimum severity is ERROR
    verify(mockLogger, never()).debug(anyString());

    logger.warn("Warn message");
    // The decorated logger should not log the message because the minimum severity is ERROR
    verify(mockLogger, never()).debug(anyString());

    logger.error("Error message");
    // The decorated logger should log the message because the severity is ERROR, which is the min severity.
    verify(mockLogger).error(anyString());
  }
}