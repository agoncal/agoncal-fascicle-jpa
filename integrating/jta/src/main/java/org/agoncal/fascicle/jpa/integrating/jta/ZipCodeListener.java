package org.agoncal.fascicle.jpa.integrating.jta;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@ApplicationScoped
public class ZipCodeListener {

  @Inject
  private ZipCodeChecker checker;

  @PrePersist
  @PreUpdate
  private void checkZipCode(Address address) {
    if (!checker.isValid(address.getZipcode()))
      throw new IllegalArgumentException("Invalid zipcode");
  }

}
// end::adocSnippet[]
