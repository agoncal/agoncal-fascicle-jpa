package org.agoncal.fascicle.jpa.managing.ex12;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class DataValidationListener {

  @PrePersist
  @PreUpdate
  private void validate(Customer customer) {
    System.out.println("DataValidationListener validateData()");
    if (customer.getFirstName() == null || "".equals(customer.getFirstName()))
      throw new IllegalArgumentException("Invalid first name");
    if (customer.getLastName() == null || "".equals(customer.getLastName()))
      throw new IllegalArgumentException("Invalid last name");
  }
}
// end::adocSnippet[]
