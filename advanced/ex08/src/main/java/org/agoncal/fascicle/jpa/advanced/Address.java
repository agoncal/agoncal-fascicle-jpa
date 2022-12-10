package org.agoncal.fascicle.jpa.advanced;

import jakarta.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Embeddable
public class Address {

  private String street1;
  private String city;
  private String zipcode;
  private String country;

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =            Constructors            =
  // ======================================

  public Address() {
  }

  public Address(String street1, String city, String zipcode, String country) {
    this.street1 = street1;
    this.city = city;
    this.zipcode = zipcode;
    this.country = country;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
