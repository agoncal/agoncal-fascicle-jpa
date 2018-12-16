package org.agoncal.fascicle.jpa.managing.ex13;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * APress Book - Beginning Java EE 6 with Glassfish 3
 * http://www.apress.com/
 * http://www.antoniogoncalves.org
 * --
 * Simple entity
 */
@EntityListeners(DebugListener.class)
@Entity
public class Person {

  // ======================================
  // =             Attributes             =
  // ======================================
  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;

// ======================================
// =            Constructors            =
// ======================================

  public Person() {
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
