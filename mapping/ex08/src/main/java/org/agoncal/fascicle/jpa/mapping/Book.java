package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Float price;
  private String description;
  private String isbn;
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "Tag")
  @Column(name = "Value")
  private List<String> tags = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, ArrayList<String> tags) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.tags = tags;
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

  public List<String> getTags() {
    return tags;
  }

  public void setTags(ArrayList<String> tags) {
    this.tags = tags;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
