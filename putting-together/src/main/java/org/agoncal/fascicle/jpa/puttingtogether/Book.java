package org.agoncal.fascicle.jpa.puttingtogether;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b")
@NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
public class Book extends Item {

  private String isbn;
  private Integer nbOfPages;
  private Boolean illustrations;
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "tag")
  @Column(name = "value")
  private List<String> tags = new ArrayList<>();

  @OneToMany
  @MapKey(name = "position")
  @MapKeyColumn(name = "chapter")
  private Map<Integer, Chapter> chapters = new HashMap<>();

  @ManyToMany
  private List<Author> authors = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Book() {
  }

  public Book(String title, String description, Float price, String isbn, Integer nbOfPages, Boolean illustrations) {
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

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Map<Integer, Chapter> getChapters() {
    return chapters;
  }

  public void setChapters(Map<Integer, Chapter> chapters) {
    this.chapters = chapters;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", isbn='").append(isbn).append('\'');
    sb.append(", nbOfPages=").append(nbOfPages);
    sb.append(", illustrations=").append(illustrations);
    sb.append('}');
    return sb.toString();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
