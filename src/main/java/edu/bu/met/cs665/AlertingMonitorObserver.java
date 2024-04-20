/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: AlertingMonitorObserver.java
 * Description: Subscriber class to receive updates and send to alerting monitors.
 */

package edu.bu.met.cs665;

/**
 *  Subscriber class to receive updates and send to alerting monitors like
 *  Datadog, etc.
 */
public class AlertingMonitorObserver implements Observer {

  /**
   * Update method that sends an alert to monitors. Right now this is a dummy
   * method that just logs to console.
   * @param message the message to send.
   */
  @Override
  public void update(String message) {
    System.out.println("Sending alert to monitors: " + message);
  }
}
