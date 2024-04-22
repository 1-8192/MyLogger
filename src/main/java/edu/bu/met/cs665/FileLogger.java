/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: FileLogger.java
 * Description: Logger type that logs to a text file.
 */

package edu.bu.met.cs665;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Logger type that logs to a text file.
 */
public class FileLogger implements Logger {
  /**
   * Next logger in chain of responsibility.
   */
  private Logger next;

  /**
   * The java writer.
   */
  private PrintWriter writer;

  /**
   * Desired date format for logs.
   */
  private String dateTimeFormat;

  /**
   * The file name to write to.
   */
  private String fileName;

  /**
    * The log object. Contains a severity and message.
    */
  private Log log;

  /**
   * The factory for log flyweights.
   */
  LogFlyweightFactory logFactory = new LogFlyweightFactory();

  /**
   * List of observers to notify of logs.
   */
  private List<Observer> observers = new ArrayList<>();

  /**
   * Private class constructor. Please see builder below.
   * @param builder the builder to use.
   */
  private FileLogger(Builder builder) {
    this.writer = builder.writer;
    this.fileName = builder.fileName;
    this.dateTimeFormat = builder.dateTimeFormat;
  }

  /**
   * Log a DEBUG message.
   * @param message the message to log.
   */
  public void debug(String message) {
    log = logFactory.getFlyweightLog(Level.DEBUG, message);
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
    log = logFactory.getFlyweightLog(Level.INFO, message);
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
    log = logFactory.getFlyweightLog(Level.WARN, message);
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
    log = logFactory.getFlyweightLog(Level.ERROR, message);
    log();
    // pass the request along to the next Logger if set.
    if (next != null) {
      next.error(message);
    }
  }

  /**
   * Log a message to the file using the java writer.
   */
  public void log() {
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
      String dateTime = LocalDateTime.now().format(formatter);
      writer.println(dateTime + " [" + log.getLevel().name() + "]: " + log.getMessage());
      writer.flush();
    } catch (Exception e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
    // Notify observers of error level logs.
    for (Observer observer : observers) {
      observer.update(log.getMessage());
    }
  }

  /**
   * Add an observer to the logger.
   * @param observer  the observer to add.
   */
  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * Remove an observer from the logger.
   * @param observer  the observer to remove.
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
   * Builder inner class for the FileLogger class.
   */
  public static class Builder {
    /**
     * The java writer.
     */
    private PrintWriter writer;

    /**
     * Desired date format for logs.
     */
    private String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * The file name to write to.
     */
    private String fileName;

    /**
     * Buidler with file name.
     * @param fileName the file name to write to.
     * @return the builder.
     */
    public Builder withFileName(String fileName) {
      try {
        FileWriter fileWriter = new FileWriter(fileName, true);
        this.writer = new PrintWriter(fileWriter);
      } catch (IOException e) {
        System.out.println(e.getStackTrace());
      }
      return this;
    }

    /**
     * Builder with date time format.
     * @param dateTimeFormat the desired date time format.
     * @return the builder.
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
     * Builder build() method.
     * @return the FileLogger.
     */
    public FileLogger build() {
      return new FileLogger(this);
    }
  }
}
