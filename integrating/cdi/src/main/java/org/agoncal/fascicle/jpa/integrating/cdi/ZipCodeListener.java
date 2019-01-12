package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class ZipCodeListener {

//  @Inject
//  private ZipCodeChecker checker;

  @PrePersist
  @PreUpdate
  private void checkZipCode(Address address) {
//      throw new IllegalArgumentException("Invalid first name");
  }


}
// end::adocSnippet[]
