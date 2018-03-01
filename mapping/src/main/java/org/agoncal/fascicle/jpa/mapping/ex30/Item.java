package org.agoncal.fascicle.jpa.mapping.ex30;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

  @Id
  @GeneratedValue
  protected Long id;
  protected String title;
  protected Float price;
  protected String description;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Item() {
  }

  public Item(String title, Float price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
