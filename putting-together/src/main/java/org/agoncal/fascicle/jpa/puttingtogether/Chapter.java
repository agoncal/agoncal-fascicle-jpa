package org.agoncal.fascicle.jpa.puttingtogether;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Chapter {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String description;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Chapter() {
  }

  public Chapter(String title, String description) {
    this.title = title;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
