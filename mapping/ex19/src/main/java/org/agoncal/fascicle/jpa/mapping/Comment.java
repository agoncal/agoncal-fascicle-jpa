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
public class Comment {

  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Comment() {
  }

  public Comment(String nickname, String content, Integer note) {
    this.nickname = nickname;
    this.content = content;
    this.note = note;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
