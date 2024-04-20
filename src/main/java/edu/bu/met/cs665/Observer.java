/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/25/2024
 * File Name: Observer.java
 * Description: Observer interface.
 */

package edu.bu.met.cs665;

/**
 * Interface for logging observers that will be notified of log messages.
 */
public interface Observer {
  void update(String message);
}
