package org.agoncal.fascicle.jpa.advanced;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Book {

  @Id
  @GeneratedValue
  private Long id;
  @Version
  private Integer version;
  private String title;
  private Float price;
  private String description;
  private String isbn;

  public void raisePriceByTwoDollars() {
    price = price + 2;
  }

  public void raisePriceByFiveDollars() {
    price = price + 5;
  }

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public Integer getVersion() {
    return version;
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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
