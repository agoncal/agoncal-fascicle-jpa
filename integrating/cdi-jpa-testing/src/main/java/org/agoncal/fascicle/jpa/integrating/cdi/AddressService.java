/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressService {

  private final List<String> names = new ArrayList<>();

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  public List<String> getTestEntityNames() {
    return names;
  }

  public void addTestEntityName(String name) {
    names.add(name);
  }

  public Address save(Address address) throws Exception {

//    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");
//    tx.begin();
    em.persist(address);
    return address;
//    tx.commit();
//    assertNotNull(address.getId(), "ID should not be null");
  }
}
