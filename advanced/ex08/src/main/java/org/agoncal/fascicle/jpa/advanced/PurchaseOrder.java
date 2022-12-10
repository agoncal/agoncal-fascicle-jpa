package org.agoncal.fascicle.jpa.advanced;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  private List<OrderLine> orderLines;

  @AttributeOverride(name = "street1", column = @Column(name = "invoice_street1"))
  @AttributeOverride(name = "city", column = @Column(name = "invoice_city"))
  @AttributeOverride(name = "zipcode", column = @Column(name = "invoice_zipcode"))
  @AttributeOverride(name = "country", column = @Column(name = "invoice_country"))
  private Address invoiceAddress;

  @AttributeOverride(name = "street1", column = @Column(name = "delivery_street1"))
  @AttributeOverride(name = "city", column = @Column(name = "delivery_city"))
  @AttributeOverride(name = "zipcode", column = @Column(name = "delivery_zipcode"))
  @AttributeOverride(name = "country", column = @Column(name = "delivery_country"))
  private Address deliveryAddress;

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

  public Address getInvoiceAddress() {
    return invoiceAddress;
  }

  public void setInvoiceAddress(Address invoiceAddress) {
    this.invoiceAddress = invoiceAddress;
  }

  public Address getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
