package org.agoncal.fascicle.jpa.managing.ex09;


import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import javax.persistence.Cache;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CachingTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckThatAddressIsCacheableEqualsFalse() throws Exception {

    Address address = new Address("Ritherdon Rd", "London", "8QE", "UK");

    // Persist the object
    tx.begin();
    em.persist(address);
    tx.commit();

    assertNotNull(address.getId());

    Cache cache = emf.getCache();

    // Address should not be in the cache
    assertFalse(cache.contains(Address.class, address.getId()));
  }

  @Test
  public void shouldCheckThatCustomerIsCacheableEqualsTrue() throws Exception {

    Customer customer = new Customer("Antony", "Balla", "tballa@mail.com");

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();

    assertNotNull(customer.getId());

    Cache cache = emf.getCache();

    // Customer should be in the cache
    assertTrue(cache.contains(Customer.class, customer.getId()));

    cache.evict(Customer.class);

    // After clearing the cache Customer should not be in the cache
    assertFalse(cache.contains(Customer.class, customer.getId()));
  }

  @Test
  public void shouldCheckThatBookIsNotCacheableByDefault() throws Exception {

    Book book = new Book(getRandomId(), "The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);

    // Persist the object
    tx.begin();
    em.persist(book);
    tx.commit();

    assertNotNull(book.getId());

    Cache cache = emf.getCache();

    // Customer should not be in the cache by default
    assertFalse(cache.contains(Customer.class, book.getId()));
  }
}
