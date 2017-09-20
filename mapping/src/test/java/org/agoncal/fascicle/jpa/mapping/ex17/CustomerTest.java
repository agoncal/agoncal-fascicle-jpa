package org.agoncal.fascicle.jpa.mapping.ex17;

import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateACustomerWithAnEmbeddedAddress() throws Exception {

    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565");
    Address address = new Address("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    customer.setAddress(address);
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull(customer.getId(), "ID should not be null");
  }
}
