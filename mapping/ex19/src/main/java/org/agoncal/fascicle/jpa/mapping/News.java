package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class News {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @JoinColumn
  @OrderColumn(name = "publication_index")
  private List<Comment> comments;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public News() {
  }

  public News(String content) {
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void addComment(Comment comment) {
    if (comments == null)
      comments = new ArrayList<Comment>();
    comments.add(comment);
  }

  public List<Comment> getComments() {
    return comments;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
