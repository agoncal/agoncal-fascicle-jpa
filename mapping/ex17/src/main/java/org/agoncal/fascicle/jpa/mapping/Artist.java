package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Artist {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  @ManyToMany
  @JoinTable(name = "jnd_art_cd", joinColumns = @JoinColumn(name = "artist_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
  private List<CD> appearsOnCDs;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Artist() {
  }

  public Artist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<CD> getAppearsOnCDs() {
    return appearsOnCDs;
  }

  public void setAppearsOnCDs(List<CD> appearsOnCDs) {
    this.appearsOnCDs = appearsOnCDs;
  }

  public void appearsOn(CD cd) {
    if (appearsOnCDs == null)
      appearsOnCDs = new ArrayList<CD>();
    appearsOnCDs.add(cd);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
