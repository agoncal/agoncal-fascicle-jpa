package org.agoncal.fascicle.jpa.integrating.cdi;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@EntityListeners({ZipCodeListener.class})
@Entity
public class Address {

  @Id @GeneratedValue
  private Long id;
  private String street1;
  private String street2;
  private String city;
  private String state;
  private String zipcode;
  private String country;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public Address street1(String street1) {
    this.street1 = street1;
    return this;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public Address street2(String street2) {
    this.street2 = street2;
    return this;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address state(String state) {
    this.state = state;
    return this;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Address zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
