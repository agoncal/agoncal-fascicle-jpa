package org.agoncal.fascicle.jpa.advanced;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Customer {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  // Constructors and setters

  // tag::adocSkip[]

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  // end::adocSkip[]
  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  @Column(name = "first_name", nullable = false, length = 50)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false, length = 50)
  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  @Column(name = "phone_number", length = 15)
  public String getPhoneNumber() {
    return phoneNumber;
  }
}
// end::adocSnippet[]
