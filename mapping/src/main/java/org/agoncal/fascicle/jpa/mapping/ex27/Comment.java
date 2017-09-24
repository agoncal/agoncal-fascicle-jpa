package org.agoncal.fascicle.jpa.mapping.ex27;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Entity
public class Comment {

  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;

  // Constructors, getters, setters
  // tag::adocskip[]

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
  // end::adocskip[]
}
// end::adocsnippet[]
