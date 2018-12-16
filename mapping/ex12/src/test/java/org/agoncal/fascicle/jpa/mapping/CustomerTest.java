package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    Address address1 = new Address("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    Address address2 = new Address("75B Ritherdon Rd", "At Peter place", "London", "LDN", "7QE554", "UK");
    Address address3 = new Address("85B Ritherdon Rd", "At Paul place", "London", "LDN", "7QE554", "UK");
    customer.setAddresses(Arrays.asList(address1, address2, address3));
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull(customer.getId(), "ID should not be null");
    assertEquals(3, customer.getAddresses().size(), "Should have 3 addresses");
  }
}
