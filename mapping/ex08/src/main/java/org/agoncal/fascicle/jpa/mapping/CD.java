package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class CD {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private Float price;
  private String description;
  @Lob
  private byte[] cover;
  @ElementCollection
  @CollectionTable(name = "track")
  @MapKeyColumn(name = "position")
  @Column(name = "title")
  private Map<Integer, String> tracks = new HashMap<>();

  // Constructors, getters, setters
  // tag::adocSkip[]

  public CD() {
  }

  public CD(String title, Float price, String description, HashMap<Integer, String> tracks) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.tracks = tracks;
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

  public byte[] getCover() {
    return cover;
  }

  public void setCover(byte[] cover) {
    this.cover = cover;
  }

  public Map<Integer, String> getTracks() {
    return tracks;
  }

  public void setTracks(HashMap<Integer, String> tracks) {
    this.tracks = tracks;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
