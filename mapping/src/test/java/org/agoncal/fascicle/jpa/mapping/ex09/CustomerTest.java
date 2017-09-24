package org.agoncal.fascicle.jpa.mapping.ex09;


import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
  public void shoulCreateACustomer() throws Exception {

    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    tx.begin();
    em.persist(customer);
    tx.commit();
    Assertions.assertNotNull(customer.getId(), "ID should not be null");
  }
}
