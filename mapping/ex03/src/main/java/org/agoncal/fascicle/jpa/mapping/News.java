package org.agoncal.fascicle.jpa.mapping;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@IdClass(NewsId.class)
public class News {

  @Id
  private String title;
  @Id
  private String language;
  private String content;

  // Constructors, getters, setters, equals, and hashcode
  // tag::adocSkip[]

  public News() {
  }

  public News(String title, String language, String content) {
    this.title = title;
    this.language = language;
    this.content = content;
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

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
