package org.agoncal.fascicle.jpa.integrating.jta;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.MANDATORY;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@ApplicationScoped
public class AddressService {

  @Inject
  private EntityManager em;

  @Transactional
  public Address save(Address address) {
    em.persist(address);
    return address;
  }

  @Transactional(value = MANDATORY)
  public String needsTransaction() {
    return "Success";
  }
}
// end::adocSnippet[]
