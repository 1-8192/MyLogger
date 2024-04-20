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
 * Class that implements a chain of responsibility for different loggers.
 */
public class LoggerChain {
  /**
   * The array of loggers to add to the chain.
   */
  private List<Logger> loggers =  new ArrayList<>();

  /**
   * Add a logger to the chain.
   * @param logger the logger to add.
   */
  public void addLogger(Logger logger) {
    loggers.add(logger);
  }

  /**
   * Debug method.
   * @param message the message to log.
   */
  public void debug(String message) {
    for (Logger logger: loggers) {
      logger.debug(message);
    }
  }

  /**
   *  Info method.
   * @param message the message to log.
   */
  public void info(String message) {
    for (Logger logger: loggers) {
      logger.info(message);
    }
  }

  /**
   * Warn method.
   * @param message   the message to log.
   */
  public void warn(String message) {
    for (Logger logger: loggers) {
      logger.warn(message);
    }
  }

  /**
   * Error method.
   * @param message   the message to log.
   */
  public void error(String message) {
    for (Logger logger: loggers) {
      logger.error(message);
    }
  }
}
