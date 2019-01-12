package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Disabled
@EnableWeld
public class AddressTest extends AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");
    tx.begin();
    em.persist(address);
    tx.commit();
    assertNotNull(address.getId(), "ID should not be null");
  }
}
