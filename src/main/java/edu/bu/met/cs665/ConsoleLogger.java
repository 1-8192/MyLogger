/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: ConsoleLogger.java
 * Description: Logger type that logs to console.
 */

package edu.bu.met.cs665;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Logger type that logs to console.
 */
public class ConsoleLogger implements Logger {
  /**
   * Next logger in chain of responsibility.
   */
  private Logger next;

  /**
   * The date time format for logs.
   */
  String dateTimeFormat;

  /**
   * List of observers to notify of logs.
   */
  private List<Observer> observers = new ArrayList<>();

  private Log log;

  /**
   * Constructor for the ConsoleLogger class. Private to force use of builder.
   * @param builder the builder to use.
   */
  private ConsoleLogger(Builder builder) {
    this.dateTimeFormat = builder.dateTimeFormat;
  }

  /**
   * Log a DEBUG message.
   * @param message the message to log.
   */
  public void debug(String message) {
    log = new Log(Level.DEBUG, message);
    log();
    // pass the request along to the next Logger if set.
    if (next != null) {
      next.debug(message);
    }
  }

  /**
   * Log an INFO message.
   * @param message the message to log.
   */
  @Override
  public void info(String message) {
    log = new Log(Level.INFO, message);
    log();
    // pass the request along to the next Logger if set.
    if (next != null) {
      next.info(message);
    }
  }

  /**
   * Log a WARN message.
   * @param message the message to log.
   */
  @Override
  public void warn(String message) {
    log = new Log(Level.WARN, message);
    log();
    // pass the request along to the next Logger if set.
    if (next != null) {
      next.warn(message);
    }
  }

  /**
   * Log an ERROR message.
   * @param message the message to log.
   */
  @Override
  public void error(String message) {
    log = new Log(Level.ERROR, message);
    log();
    // pass the request along to the next Logger if set.
    if (next != null) {
      next.error(message);
    }
  }

  /**
   * Log a message to the console.
   */
  private void log() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
    String dateTime = LocalDateTime.now().format(formatter);
    System.out.println(dateTime + " [" + log.getLevel().name() + "]: " + log.getMessage());
    // Notify observers.
    for (Observer observer : observers) {
      observer.update(log.getMessage());
    }
  }

  /**
   * Method to add an observer to the logger.
   * @param observer the observer to add.
   */
  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * Method to remove an observer from the logger.
   * @param observer the observer to remove.
   */
  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Sets the next logger in the chain of responsibility.
   * @param next the next logger in the chain.
   */
  @Override
  public void setNext(Logger next) {
    this.next = next;
  }

  /**
   * Builder inner class for the ConsoleLogger class.
   */
  public static class Builder {
    /**
     * The date time format for logs.
     */
    private String dateTimeFormat;

    /**
     * Build with date format.
     */
    public Builder withDateTimeFormat(String dateTimeFormat) {
      try {
        DateTimeFormatter.ofPattern(dateTimeFormat);
        this.dateTimeFormat = dateTimeFormat;
      } catch (DateTimeParseException e) {
        System.out.println("Invalid date time format. Using default format.");
      }
      return this;
    }

    /**
     * Build the ConsoleLogger with the build() method.
     * @return the ConsoleLogger.
     */
    public ConsoleLogger build() {
      return new ConsoleLogger(this);
    }
  }
}
