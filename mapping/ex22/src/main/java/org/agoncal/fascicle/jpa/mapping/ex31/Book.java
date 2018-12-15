package org.agoncal.fascicle.jpa.mapping.ex31;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
@Table(name = "ex60_book")
public class Book extends Item {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String isbn;
  private String publisher;
  private Integer nbOfPages;
  private Boolean illustrations;

  // ======================================
  // =            Constructors            =
  // ======================================

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
}
