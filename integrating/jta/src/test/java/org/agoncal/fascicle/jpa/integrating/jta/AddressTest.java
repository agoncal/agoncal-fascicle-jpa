package org.agoncal.fascicle.jpa.integrating.jta;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Disabled
//@EnableWeld
public class AddressTest extends AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private AddressService addressService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");
//    tx.begin();
    addressService.save(address);
//    tx.commit();
    assertNotNull(address.getId(), "ID should not be null");
  }
}
