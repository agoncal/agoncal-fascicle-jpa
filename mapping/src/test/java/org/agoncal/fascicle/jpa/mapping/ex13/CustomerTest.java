package org.agoncal.fascicle.jpa.mapping.ex13;

import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
  public void shouldCreateACustomer() throws Exception {

    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565");
    tx.begin();
    em.persist(customer);
    tx.commit();
    Assertions.assertNotNull(customer.getId(), "ID should not be null");
  }
}
