/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: LoggerChain.java
 * Description: Class that implements a chain of responsibility for different loggers.
 */

package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements a chain of responsibility for different loggers. It keeps tab
 * of the first and last logger in the chain in order to set the 'next' logger variable for
 * the correct logger instance. For every log method, it sets off the chain by logging
 * to the first logger in the chain.
 */
public class LoggerChain {
  /**
   * The array of loggers to add to the chain.
   */
  private Logger firstLogger;
  private Logger lastLogger;

  /**
   * Add a logger to the chain.
   * @param logger the logger to add.
   */
  public void addLogger(Logger logger) {
    if (firstLogger == null) {
      firstLogger = logger;
      lastLogger = logger;
    } else {
      lastLogger.setNext(logger);
      lastLogger = logger;
    }
  }

  /**
   * Debug method.
   * @param message the message to log.
   */
  public void debug(String message) {
    if (firstLogger != null) {
      firstLogger.debug(message);
    }
  }

  /**
   *  Info method.
   * @param message the message to log.
   */
  public void info(String message) {
    if (firstLogger != null) {
      firstLogger.info(message);
    }
  }

  /**
   * Warn method.
   * @param message   the message to log.
   */
  public void warn(String message) {
    if (firstLogger != null) {
      firstLogger.warn(message);
    }
  }

  /**
   * Error method.
   * @param message   the message to log.
   */
  public void error(String message) {
    if (firstLogger != null) {
      firstLogger.error(message);
    }
  }
}
