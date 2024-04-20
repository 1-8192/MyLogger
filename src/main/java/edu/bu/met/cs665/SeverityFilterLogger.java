/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: SeverityFilterLogger.java
 * Description: Decorator class to filter log messages by severity.
 */

package edu.bu.met.cs665;

/**
 * Decorator class to filter log messages by severity. Sets a minimum
 * severity that has to be met for loggers to actually log messages.
 */
public class SeverityFilterLogger extends LoggerDecorator {
  /**
   * The minimum severity needed to reach to log messges. Defaults to INFO.
   * The type is an enum of different accepted levels.
   */
  private Level minSeverity = Level.DEBUG;

  /**
   * Constructor for the SeverityFilterLogger class that accepts severity.
   * @param decoratedLogger the logger to decorate.
   * @param minSeverity the desired minimum severity.
   */
  private SeverityFilterLogger(Logger decoratedLogger, Level minSeverity) {
    super(decoratedLogger);
    this.minSeverity = minSeverity;
  }

  /**
   * Log a message with severity DEBUG.
   * @param message the message
   */
  @Override
  public void debug(String message) {
    if (minSeverity.getSeverity() <= Level.DEBUG.getSeverity()) {
      decoratedLogger.info(message);
    }
  }

  /**
   * Log a message with severity INFO.
   * @param message the message
   */
  @Override
  public void info(String message) {
    if (minSeverity.getSeverity() <= Level.INFO.getSeverity()) {
      decoratedLogger.info(message);
    }
  }

  /**
   * Log a message with severity WARN.
   * @param message the message
   */
  @Override
  public void warn(String message) {
    if (minSeverity.getSeverity() <= Level.WARN.getSeverity()) {
      decoratedLogger.warn(message);
    }
  }

  /**
   * Log a message with severity ERROR.
   * @param message the message
   */
  @Override
  public void error(String message) {
    if (minSeverity.getSeverity() <= Level.ERROR.getSeverity()) {
      decoratedLogger.error(message);
    }
  }

  /**
   * Builder inner class for the SeverityFilterLogger class.
   */
  public static class Builder {
    /**
     * The decorated logger.
     */
    private Logger decoratedLogger;

    /**
     * The minimum severity needed to reach to log messages.
     */
    private Level minSeverity = Level.DEBUG;

    /**
     * Build with logger.
     * @param decoratedLogger the logger to decorate
     * @return return builder.
     */
    public Builder withLogger(Logger decoratedLogger) {
      this.decoratedLogger = decoratedLogger;
      return this;
    }

    /**
     * Build with minimum severity.
     * @param minSeverity   the minimum severity needed to reach to log messages.
     * @return return builder.
     */
    public Builder withMinSeverity(Level minSeverity) {
      this.minSeverity = minSeverity;
      return this;
    }

    /**
     * Builder pattern build() method returns the SeverityFilterLogger..
     * @return return SeverityFilterLogger.
     */
    public SeverityFilterLogger build() {
      return new SeverityFilterLogger(decoratedLogger, minSeverity);
    }
  }
}
