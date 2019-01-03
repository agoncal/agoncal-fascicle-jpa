package org.agoncal.fascicle.jpa.managing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  public void shouldRemoveACustomerAndRemoveAddressOrphan() throws Exception {

    // tag::adocOrphan[]
    Customer customer = new Customer("Antony", "Balla", "tballa@mail.com");
    Address address = new Address("Ritherdon Rd", "London", "8QE", "UK");
    customer.setAddress(address);

    // Persist the object
    tx.begin();
    em.persist(customer);
    em.persist(address);
    tx.commit();

    assertNotNull(customer.getId());
    assertNotNull(address.getId());

    // Removes only the customer entity from the database
    tx.begin();
    em.remove(customer);
    tx.commit();

    // Customer is not in the database, nor address
    customer = em.find(Customer.class, customer.getId());
    assertNull(customer);
    address = em.find(Address.class, address.getId());
    assertNull(address);
    // end::adocOrphan[]
  }
}
