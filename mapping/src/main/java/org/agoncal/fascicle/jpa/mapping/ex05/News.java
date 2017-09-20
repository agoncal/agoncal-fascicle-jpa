package org.agoncal.fascicle.jpa.mapping.ex05;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocsnippet[]
@Entity
public class News {

  @EmbeddedId
  private NewsId id;
  private String content;

  // Constructors, getters, setters, equals, and hashcode
  // tag::adocskip[]

  public News() {
  }

  public News(NewsId id, String content) {
    this.id = id;
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public NewsId getId() {
    return id;
  }

  public void setId(NewsId id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  // end::adocskip[]
}
// end::adocsnippet[]
