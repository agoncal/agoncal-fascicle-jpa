package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

  @Id
  @GeneratedValue
  private Long id;
  private LocalDateTime creationDate;
  private List<OrderLine> orderLines;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public PurchaseOrder() {
    this.creationDate = LocalDateTime.now();
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
