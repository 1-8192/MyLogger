/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: LogFlyweightFactory.java
 * Description: A factory class for log flyweights.
 */

package edu.bu.met.cs665;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory class for log flyweights. Mapping log levels to specific messages to reduce
 * memory usage for log objects. Only allows for one level of log to be instantiated at one time.
 */
public class LogFlyweightFactory {
  /**
   * A map of log levels to log objects.
   */
  private Map<Level, Log> logMap = new HashMap<>();

  /**
   * Loads a log from the map if it exists, otherwise creates a new log.
   * @param level the log level.
   * @param message the message to log.
   * @return a log object.
   */
  public Log getFlyweightLog(Level level, String message) {
    Log log = logMap.get(level);
    if (log == null) {
      log = new Log(level, message);
      logMap.put(level, log);
    }
    return log;
  }
}
