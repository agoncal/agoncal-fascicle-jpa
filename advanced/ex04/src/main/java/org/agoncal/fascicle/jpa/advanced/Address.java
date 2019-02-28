package org.agoncal.fascicle.jpa.advanced;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Embeddable
@Access(AccessType.PROPERTY)
public class Address {

  private String street1;
  private String street2;
  private String city;
  private String state;
  private String zipcode;
  private String country;

  // Constructors and setters
  // tag::adocSkip[]

  public Address() {
  }

  public Address(String street1, String street2, String city, String state, String zipcode, String country) {
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  // end::adocSkip[]

  @Column(nullable = false)
  public String getStreet1() {
    return street1;
  }

  public String getStreet2() {
    return street2;
  }

  @Column(nullable = false, length = 50)
  public String getCity() {
    return city;
  }

  @Column(length = 3)
  public String getState() {
    return state;
  }

  @Column(name = "zip_code", length = 10)
  public String getZipcode() {
    return zipcode;
  }

  public String getCountry() {
    return country;
  }
}
// end::adocSnippet[]
