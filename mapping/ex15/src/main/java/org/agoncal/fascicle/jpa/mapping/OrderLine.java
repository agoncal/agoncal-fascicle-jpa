package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@Table(name = "order_line")
public class OrderLine {

  @Id
  @GeneratedValue
  private Long id;
  private String item;
  private Double unitPrice;
  private Integer quantity;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public OrderLine() {
  }

  public OrderLine(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
