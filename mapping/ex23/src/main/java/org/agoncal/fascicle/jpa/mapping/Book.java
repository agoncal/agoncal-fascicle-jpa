package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Table(name = "override_book")
// tag::adocSnippet[]
@Entity
@AttributeOverrides({
  @AttributeOverride(name = "id", column = @Column(name = "book_id")),
  @AttributeOverride(name = "title", column = @Column(name = "book_title")),
  @AttributeOverride(name = "description", column = @Column(name = "book_description"))
})
public class Book extends Item {

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
