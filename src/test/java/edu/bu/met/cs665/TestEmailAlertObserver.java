/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: TestEmailAlertObserver.java
 * Description: Unit tests for Email alert observer.
 */

package edu.bu.met.cs665;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the update method in the EmailAlertObserver class.
 * I used this guide generally to help me test console output: https://www.baeldung.com/java-testing-system-out-println
 */
public class TestEmailAlertObserver {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void testUpdate() {
    EmailAlertObserver observer = new EmailAlertObserver("test@example.com");
    observer.update("Test message");

    String expectedOutput = "Sending email to test@example.com with message: Test message\n";
    assertEquals(expectedOutput, outContent.toString());
  }
}