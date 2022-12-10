package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
  @OneToMany
  @JoinTable(name = "jnd_ord_line",
    joinColumns = @JoinColumn(name = "order_fk"),
    inverseJoinColumns = @JoinColumn(name = "order_line_fk")
  )
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
