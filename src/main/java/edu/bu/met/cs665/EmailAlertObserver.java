/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: EmailAlertObserver.java
 * Description: Subscriber class that sends email alerts.
 */

package edu.bu.met.cs665;

/**
 * Subscriber class that sends email alerts.
 */
public class EmailAlertObserver implements Observer {
  /**
   * The email address to send alerts to.
   */
  private String emailAddress;

  /**
   * Constructor for the EmailAlertObserver class.
   * @param emailAddress  the email address to send alerts to.
   */
  public EmailAlertObserver(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * Update method that sends an email alert. Right now this is a dummy
   * method that only logs to the console.
   * @param message the message to send.
   */
  @Override
  public void update(String message) {
    System.out.println("Sending email to " + emailAddress
          + " with message: " + message);
  }
}
