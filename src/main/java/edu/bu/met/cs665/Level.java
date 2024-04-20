/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: Level.java
 * Description: Enum for different log levels.
 */

package edu.bu.met.cs665;

/**
 * Enum for different log levels.
 */
public enum Level {
  DEBUG(0) {
    @Override
    public String toString() {
      return "DEBUG";
    }
  },
  INFO(1) {
    @Override
    public String toString() {
      return "INFO";
    }
  },
  WARN(2) {
    @Override
    public String toString() {
      return "WARN";
    }
  },
  ERROR(3) {
    @Override
    public String toString() {
      return "ERROR";
    }
  };

  private final int severity;

  Level(int severity) {
    this.severity = severity;
  }

  public int getSeverity() {
    return severity;
  }
}
