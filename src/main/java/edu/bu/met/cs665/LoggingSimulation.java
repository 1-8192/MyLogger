/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: LoggingSImulation.java
 * Description: Singleton Class to run a Logging simulation.
 */

package edu.bu.met.cs665;

/**
 * Singleton Class to run a Logging simulation.
 */
public class LoggingSimulation {
  // Create a private static instance of the class as per Singleton Pattern.
  private static LoggingSimulation instance;

  /**
   * Private singleton class constructor.
   */
  private LoggingSimulation() {}

  /**
   * Retuns a singleton instance of the class.
   * @return LoggingSimulation instance
   */
  public static LoggingSimulation getInstance() {
    if (instance == null) {
      instance = new LoggingSimulation();
    }
    return instance;
  }

  /**
   * Method to run the logging simulation to show logging examples.
   */
  public void runLoggingSimulation() {
    // Use lof builders to build different types of loggers.
    FileLogger fileLogger = new FileLogger.Builder().withFileName("logs.txt")
          .withDateTimeFormat("yyyy-MM-dd HH:mm:ss").build();
    Logger consoleLogger = new ConsoleLogger.Builder()
          .withDateTimeFormat("yyyy-MM-dd HH:mm:ss").build();

    // Create a logger chain and add loggers to it
    LoggerChain loggerChain = new LoggerChain();
    loggerChain.addLogger(fileLogger);
    loggerChain.addLogger(consoleLogger);

    System.out.println("Example logs of various levels: \n");
    // Log some messages.
    loggerChain.debug("Are we Hello, world!");
    loggerChain.info("Hello, world!");
    loggerChain.warn("Hello, world?");
    loggerChain.error("Goodbye, world!");

    // Creating observers and appending to the loggers
    Observer observer = new EmailAlertObserver("test@test.com");
    Observer observer2 = new AlertingMonitorObserver();
    consoleLogger.addObserver(observer);
    consoleLogger.addObserver(observer2);
    fileLogger.addObserver(observer);
    fileLogger.addObserver(observer2);

    System.out.println("\nExample logs of various levels with subscribed observers: \n");
    // Log some messages.
    loggerChain.debug("Are we Hello, world!");
    loggerChain.info("Hello, world!");
    loggerChain.warn("Hello, world?");
    loggerChain.error("Goodbye, world!");

    // Add severity filter to the console logger using decorator pattern.
    consoleLogger.removeObserver(observer);
    consoleLogger.removeObserver(observer2);
    SeverityFilterLogger severityFilterLogger = new SeverityFilterLogger.Builder()
          .withLogger(consoleLogger)
          .withMinSeverity(Level.WARN)
          .build();

    System.out.println("\nExample logs of various levels with severity "
          + "filter Nothing below WARN should show: \n");
    // Log messages based on severity filters applied.
    severityFilterLogger.debug("Are we Hello, world!");  // This will not be logged
    severityFilterLogger.info("Hello, world!");  // This will not be logged
    severityFilterLogger.warn("Hello, world?");  // This will be logged
    severityFilterLogger.error("Goodbye, world!");  // This will be logged
  }
}
