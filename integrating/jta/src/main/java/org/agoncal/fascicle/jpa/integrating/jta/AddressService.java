package org.agoncal.fascicle.jpa.integrating.jta;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import static jakarta.transaction.Transactional.TxType.MANDATORY;
import static jakarta.transaction.Transactional.TxType.REQUIRED;

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

  @Transactional(REQUIRED)
  public Address save(Address address) {
    em.persist(address);
    return address;
  }

  @Transactional(MANDATORY)
  public String needsATransaction() {
    return "Success";
  }
}
// end::adocSnippet[]
