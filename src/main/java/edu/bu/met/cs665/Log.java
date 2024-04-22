/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: Log.java
 * Description: A class representing a log message.
 */

package edu.bu.met.cs665;

/*
  * A class representing a log message. This is meant to be a flyweight object, please
  * see the LogFlyweightFactory class for more information.
 */
public final class Log {
  /**
   * The log's level.
   */
  private Level level;

  /**
   * The message log.
   */
  private String message;

  /**
   * Constructor for a log message.
   * @param level the log's level.
   * @param message the message log.
   */
  public Log(Level level, String message) {
    this.level = level;
    this.message = message;
  }

  // Getters and setters for the private variables.

  public Level getLevel() {
    return level;
  }

  public String getMessage() {
    return message;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
