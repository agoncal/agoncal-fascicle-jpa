/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
