package org.agoncal.fascicle.jpa.querying;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerDTO {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String firstName;
  private String lastName;
  private String country;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CustomerDTO() {
  }

  public CustomerDTO(String firstName, String lastName, String country) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.country = country;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
