/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: TestConsoleLogger.java
 * Description: Unit tests for Console Logger.
 */

package edu.bu.met.cs665;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for Console Logger.
 * I used this guide generally to help me test console output: https://www.baeldung.com/java-testing-system-out-println
 */
public class TestConsoleLogger {
  // Declaring necessary classes and streams needed to confirm test results.
  // Also setting up necessary classes to test.

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private ConsoleLogger consoleLogger;
  private Observer observer;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    consoleLogger = new ConsoleLogger.Builder().withDateTimeFormat("yyyy-MM-dd HH:mm:ss").build();
    observer = Mockito.mock(Observer.class);
  }

  // Testing various log Levels.
  @Test
  public void testDebugLog() {
    consoleLogger.debug("Test debug log");
    assertTrue(outContent.toString().contains("[DEBUG]: Test debug log"));
  }

  @Test
  public void testInfoLog() {
    consoleLogger.info("Test info log");
    assertTrue(outContent.toString().contains("[INFO]: Test info log"));
  }

  @Test
  public void testWarnLog() {
    consoleLogger.warn("Test warn log");
    assertTrue(outContent.toString().contains("[WARN]: Test warn log"));
  }

  @Test
  public void testErrorLog() {
    consoleLogger.error("Test error log");
    assertTrue(outContent.toString().contains("[ERROR]: Test error log"));
  }

  /**
   * Testing the adding and removing of observers specifically.
   */
  @Test
  public void testAddAndRemoveObserver() {
    consoleLogger.addObserver(observer);
    consoleLogger.error("Test error log");
    Mockito.verify(observer).update("Test error log");

    consoleLogger.removeObserver(observer);
    consoleLogger.error("Test error log");
    Mockito.verify(observer, Mockito.times(1)).update("Test error log");
  }
}