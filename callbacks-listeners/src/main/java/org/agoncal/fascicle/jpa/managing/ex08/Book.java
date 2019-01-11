package org.agoncal.fascicle.jpa.managing.ex08;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@NamedStoredProcedureQuery(name = "archiveOldBooks", procedureName = "sp_archive_books",
  parameters = {
    @StoredProcedureParameter(name = "archiveDate", mode = ParameterMode.IN, type = Date.class),
    @StoredProcedureParameter(name = "warehouse", mode = ParameterMode.IN, type = String.class)
  })
public class Book {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private Float price;
  private String description;
  private String isbn;
  private String editor;
  private Integer nbOfPages;
  private Boolean illustrations;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, Integer nbOfPages, Boolean illustrations, String editor) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPages = nbOfPages;
    this.illustrations = illustrations;
    this.editor = editor;
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

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
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
