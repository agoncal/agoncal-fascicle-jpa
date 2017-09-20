package org.agoncal.fascicle.jpa.mapping.ex07;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocsnippet[]
@Entity
public class Track {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Float duration;
  @Basic(fetch = FetchType.LAZY)
  @Lob
  private byte[] wav;
  private String description;

  // Constructors, getters, setters
  // tag::adocskip[]

  public Track() {
  }

  public Track(String title, Float duration, String description) {
    this.title = title;
    this.duration = duration;
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

  public Float getDuration() {
    return duration;
  }

  public void setDuration(Float duration) {
    this.duration = duration;
  }

  public byte[] getWav() {
    return wav;
  }

  public void setWav(byte[] wav) {
    this.wav = wav;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  // end::adocskip[]
}
// end::adocsnippet[]
