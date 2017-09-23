package org.agoncal.fascicle.jpa.mapping.ex32;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Table(name = "override_item")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  protected Long id;
  protected String title;
  protected Float price;
  protected String description;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Item() {
  }

  public Item(String title, Float price, String description) {
    this.title = title;
    this.price = price;
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
}
