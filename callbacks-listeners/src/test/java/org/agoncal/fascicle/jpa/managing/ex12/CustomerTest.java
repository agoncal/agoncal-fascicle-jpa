package org.agoncal.fascicle.jpa.managing.ex12;

import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
  public void shouldCheckTheAgeOfTheCustomer() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    assertFalse(em.contains(customer));

    // Persists the object
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after persisting");
    assertEquals(new Integer(0), customer.getAge());

    // Finds the object
    customer = em.find(Customer.class, customer.getId());
    assertTrue(em.contains(customer), "should be in the persistence context after finding");
    assertEquals(new Integer(0), customer.getAge());

    // Removes the entity
    tx.begin();
    em.remove(customer);
    tx.commit();
    assertFalse(em.contains(customer), "should not be in the persistence context after removing");
  }

  @Test //(expected = IllegalArgumentException.class)
  public void shouldThrowAnExceptionBecauseFirstNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer(null, "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();
  }

  @Test //(expected = IllegalArgumentException.class)
  public void shouldThrowAnExceptionBecauseLastNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", null, "jsmith@gmail.com", "1234565", new Date(), new Date());

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();
  }
}
