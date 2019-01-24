package org.agoncal.fascicle.jpa.integrating.jta;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class AddressService {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =              Methods               =
  // ======================================

  public Address save(Address address) throws Exception {

//    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");
//    tx.begin();
    em.persist(address);
    return address;
//    tx.commit();
//    assertNotNull(address.getId(), "ID should not be null");
  }
}
