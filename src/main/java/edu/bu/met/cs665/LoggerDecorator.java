/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: LoggerDecorator.java
 * Description: Decorator abstract class that sets decorator behavior.
 */

package edu.bu.met.cs665;

/**
 * Decorator abstract class that sets decorator behavior.
 */
public abstract class LoggerDecorator implements Logger {
  /**
   * The logger to decorate.
   */
  protected Logger decoratedLogger;

  /**
   * Constructor for the LoggerDecorator class.
   * @param decoratedLogger   the logger to decorate.
   */
  public LoggerDecorator(Logger decoratedLogger) {
    this.decoratedLogger = decoratedLogger;
  }

  /**
   * debug log method.
   * @param message the message to log.
   */
  @Override
  public void debug(String message) {
    decoratedLogger.debug(message);
  }

  /**
   * info log method.
   * @param message the message to log.
   */
  @Override
  public void info(String message) {
    decoratedLogger.info(message);
  }

  /**
   * warn log method.
   * @param message the message to log.
   */
  @Override
  public void warn(String message) {
    decoratedLogger.warn(message);
  }

  /**
   * error log method.
   * @param message  the message to log.
   */
  @Override
  public void error(String message) {
    decoratedLogger.error(message);
  }

  /**
   * Method to add an observer to the logger.
   * @param observer the observer to add.
   */
  @Override
  public void addObserver(Observer observer) {
    decoratedLogger.addObserver(observer);
  }

  /**
   * Method to remove an observer from the logger.
   * @param observer the observer to remove.
   */
  @Override
  public void removeObserver(Observer observer) {
    decoratedLogger.removeObserver(observer);
  }

  /**
   * Sets the next logger in the chain of responsibility.
   * @param next the next logger in the chain.
   */
  @Override
  public void setNext(Logger next) {
    decoratedLogger.setNext(next);
  }
}
