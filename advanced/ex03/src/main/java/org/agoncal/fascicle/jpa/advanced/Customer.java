package org.agoncal.fascicle.jpa.advanced;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@Access(AccessType.FIELD)
public class Customer {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;
  private String email;
  @Column(name = "phone_number", length = 15)
  private String phoneNumber;

  // Constructors, getters, setters

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  // end::adocSkip[]
  @Access(AccessType.PROPERTY)
  @Column(name = "phone_number", length = 555)
  public String getPhoneNumber() {
    return phoneNumber;
  }
}
// end::adocSnippet[]
