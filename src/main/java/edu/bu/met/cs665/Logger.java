/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: Logger.java
 * Description: Interface for logger classes to implement.
 */

package edu.bu.met.cs665;

/**
 * Logger interface provides basic contracts for logger classes to
 * implement.
 */
public interface Logger {
  /**
   * Log debug level message.
   * @param message the message to log.
   */
  void debug(String message);

  /**
   * Log info level message.
   * @param message the message to log.
   */
  void info(String message);

  /**
   * Log warn level message.
   * @param message the message to log.
   */
  void warn(String message);

  /**
   * Log error level message.
   * @param message the message to log.
   */
  void error(String message);

  /**
   * Loggers should publish messages to subscribers and so will implement
   * methods to add or remove subscribers.
   * @param observer  the observer to add.
   */
  void addObserver(Observer observer);

  /**
   * Loggers should publish messages to subscribers and so will implement
   * methods to add or remove subscribers.
   * @param observer  the observer to remove.
   */
  void removeObserver(Observer observer);
}
