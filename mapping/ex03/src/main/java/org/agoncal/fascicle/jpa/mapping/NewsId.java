package org.agoncal.fascicle.jpa.mapping;

import java.io.Serializable;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class NewsId implements Serializable {

  private String title;
  private String language;

  // Constructors, getters, setters, equals, and hashcode
  // tag::adocSkip[]

  public NewsId() {
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

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NewsId newsId = (NewsId) o;

    if (!language.equals(newsId.language)) return false;
    if (!title.equals(newsId.title)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = title.hashCode();
    result = 31 * result + language.hashCode();
    return result;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
