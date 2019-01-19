package org.agoncal.fascicle.jpa.advanced;


import org.junit.jupiter.api.Test;

import javax.persistence.Cache;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // tag::adocSnippet[]
    Customer customer = new Customer("Patricia", "Jane", " plecomte@mail.com ");

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();

    assertNotNull(customer.getId());

    // Uses the EntityManagerFactory to get the Cache
    Cache cache = emf.getCache();

    // Customer should be in the cache
    assertTrue(cache.contains(Customer.class, customer.getId()));

    // Removes the Customer entity from the cache
    cache.evict(Customer.class);

    // After clearing the cache Customer should not be in the cache anymore
    assertFalse(cache.contains(Customer.class, customer.getId()));
    // end::adocSnippet[]
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
