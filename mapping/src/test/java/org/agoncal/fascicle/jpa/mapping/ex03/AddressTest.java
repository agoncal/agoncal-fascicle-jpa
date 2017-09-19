package org.agoncal.fascicle.jpa.mapping.ex03;


import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class AddressTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address(getRandomId(), "65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    tx.begin();
    em.persist(address);
    tx.commit();
    assertNotNull(address.getId(), "ID should not be null");
  }
}
