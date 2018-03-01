package org.agoncal.fascicle.jpa.mapping.ex10;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@Table(name = "credit_card")
public class CreditCard {

  @Id
  private String number;
  private String expiryDate;
  private Integer controlNumber;
  // tag::adocSkipenum[]
  @Enumerated(EnumType.STRING)
  // end::adocSkipenum[]
  private CreditCardType creditCardType;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public CreditCard() {
  }

  public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.creditCardType = creditCardType;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public CreditCardType getType() {
    return creditCardType;
  }

  public void setType(CreditCardType creditCardType) {
    this.creditCardType = creditCardType;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
