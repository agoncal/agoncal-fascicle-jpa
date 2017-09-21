package org.agoncal.fascicle.jpa.mapping.ex26;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocsnippet[]
@Entity
public class News {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderBy("postedDate DESC")
  private List<Comment> comments;

  // Constructors, getters, setters
  // tag::adocskip[]

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
  // end::adocskip[]
}
// end::adocsnippet[]
