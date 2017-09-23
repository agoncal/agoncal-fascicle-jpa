package org.agoncal.fascicle.jpa.mapping.ex08;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "book_title", nullable = false, updatable = false)
  private String title;
  private Float price;
  @Column(length = 2000)
  private String description;
  private String isbn;
  @Column(name = "nb_of_pages", nullable = false)
  private Integer nbOfPages;
  private Boolean illustrations;

  // Constructors, getters, setters
  // tag::adocskip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, Integer nbOfPages, Boolean illustrations) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPages = nbOfPages;
    this.illustrations = illustrations;
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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }
  // end::adocskip[]
}
// end::adocsnippet[]
