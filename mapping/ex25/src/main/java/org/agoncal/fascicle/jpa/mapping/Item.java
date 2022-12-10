package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;

import static jakarta.persistence.InheritanceType.JOINED;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@MappedSuperclass
@Inheritance(strategy = JOINED)
public abstract class Item {

  @Id
  @GeneratedValue
  protected Long id;
  @Column(length = 50, nullable = false)
  protected String title;
  @Column(length = 2000)
  protected String description;
  protected Float price;

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
