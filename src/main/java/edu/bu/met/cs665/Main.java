/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: Main.java
 * Description: The main executable class.
 */

package edu.bu.met.cs665;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * It instantiates and runs a logging simulation.
   */
  public static void main(String[] args) {
    // Creating an instance of a logging simulation to run logger examples.
    // The simulation class is a Singleton.
    LoggingSimulation logSim = LoggingSimulation.getInstance();
    logSim.runLoggingSimulation();
  }
}
