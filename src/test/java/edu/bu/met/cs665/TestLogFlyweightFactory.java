/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: TestLogFlyweightFactory.java
 * Description: Unit tests for the factory class for log flyweights.
 */

package edu.bu.met.cs665;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the factory class for log flyweights.
 */
public class TestLogFlyweightFactory {

  /**
   * Test the getFlyweightLog method.
   */
  @Test
  public void testGetFlyweightLog() {
    // Setting up necessary variables.
    LogFlyweightFactory factory = new LogFlyweightFactory();
    Log log1 = factory.getFlyweightLog(Level.INFO, "Test message 1");
    Log log2 = factory.getFlyweightLog(Level.INFO, "Test message 2");
    Log log3 = factory.getFlyweightLog(Level.ERROR, "Test message 3");

    // Since we are using the same level, the factory should return the same Log object
    assertSame(log1, log2);

    // Different level should result in a different Log object
    assertNotSame(log1, log3);
  }
}