package org.agoncal.fascicle.jpa.callbackslisteners;

import jakarta.persistence.Entity;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.Transient;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ExcludeDefaultListeners()
@Entity
public class Customer extends Person {

  private String email;
  private String phoneNumber;
  @Transient
  private Integer age;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    super(firstName, lastName);
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
