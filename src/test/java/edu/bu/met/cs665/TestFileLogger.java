/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: TestFileLogger.java
 * Description: Unit tests for File Logger.
 */

package edu.bu.met.cs665;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for File Logger. Using a buffered reader to read file contents
 * and confirm log behavior. This was sort of tough, but I used this blog as
 * a general guide: https://blogs.oracle.com/javamagazine/post/working-and-unit-testing-with-temporary-files-in-java
 */
public class TestFileLogger {
  // Setting up necessary classes and objects to test.
  private FileLogger fileLogger;
  private Observer observer;
  private String fileName = "test-log.txt";

  @BeforeEach
  public void setUp() {
    fileLogger = new FileLogger.Builder().withDateTimeFormat("yyyy-MM-dd HH:mm:ss").withFileName(fileName).build();
    observer = Mockito.mock(Observer.class);
  }

  // Testing various log Levels using custom method to read file contents.
  @Test
  public void testDebugLog() throws IOException {
    fileLogger.debug("Test debug log");
    assertTrue(readLastLine().contains("[DEBUG]: Test debug log"));
  }

  @Test
  public void testInfoLog() throws IOException {
    fileLogger.info("Test info log");
    assertTrue(readLastLine().contains("[INFO]: Test info log"));
  }

  @Test
  public void testWarnLog() throws IOException {
    fileLogger.warn("Test warn log");
    assertTrue(readLastLine().contains("[WARN]: Test warn log"));
  }

  @Test
  public void testErrorLog() throws IOException {
    fileLogger.error("Test error log");
    assertTrue(readLastLine().contains("[ERROR]: Test error log"));
  }

  @Test
  public void testAddAndRemoveObserver() {
    fileLogger.addObserver(observer);
    fileLogger.error("Test error log");
    Mockito.verify(observer).update("Test error log");

    fileLogger.removeObserver(observer);
    fileLogger.error("Test error log");
    Mockito.verify(observer, Mockito.times(1)).update("Test error log");
  }

  /**
   * Custom method to read the last line of a file using a buffered reader. Genral idea taken from
   * https://blogs.oracle.com/javamagazine/post/working-and-unit-testing-with-temporary-files-in-java
   * @return the last line of the file.
   * @throws IOException if there is an issue reading the file.
   */
  private String readLastLine() throws IOException {
    String lastLine = "";
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        lastLine = line;
      }
    }
    return lastLine;
  }
}