package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Book extends Item {

  @Id
  @GeneratedValue
  protected Long id;
  private String isbn;
  private String publisher;
  private Integer nbOfPages;
  private Boolean illustrations;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, String publisher, Integer nbOfPages, Boolean illustrations) {
    super(title, price, description);
    this.isbn = isbn;
    this.publisher = publisher;
    this.nbOfPages = nbOfPages;
    this.illustrations = illustrations;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
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
  // end::adocSkip[]
}
// end::adocSnippet[]
