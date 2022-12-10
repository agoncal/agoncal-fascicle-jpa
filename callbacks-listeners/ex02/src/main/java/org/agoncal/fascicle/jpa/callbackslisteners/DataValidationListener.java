package org.agoncal.fascicle.jpa.callbackslisteners;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

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
    if (customer.getFirstName() == null || customer.getFirstName().isEmpty())
      throw new IllegalArgumentException("Invalid first name");
    if (customer.getLastName() == null || customer.getLastName().isEmpty())
      throw new IllegalArgumentException("Invalid last name");
  }
}
// end::adocSnippet[]
