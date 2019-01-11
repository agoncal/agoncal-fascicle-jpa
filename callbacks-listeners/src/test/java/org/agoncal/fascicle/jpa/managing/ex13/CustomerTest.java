package org.agoncal.fascicle.jpa.managing.ex13;

import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  public void shouldShowDifferentLifeCyclePhases() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565");
    assertFalse(em.contains(customer));

    // Persists the object
    System.out.println("\nPERSIST");
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after persisting");

    // Finds the object
    System.out.println("\nFIND");
    em.clear();
    assertFalse(em.contains(customer), "should not be in the persistence context after clearing");
    customer = em.find(Customer.class, customer.getId());
    assertTrue(em.contains(customer), "should be in the persistence context after finding");

    // Detaches the object
    System.out.println("\nDETACH");
    em.detach(customer);
    assertFalse(em.contains(customer), "should not be in the persistence context after detaching");
    customer = em.find(Customer.class, customer.getId());
    assertTrue(em.contains(customer), "should be in the persistence context after finding");

    // Refreshes the object
    System.out.println("\nREFRESH");
    customer.setEmail("newone@mail.com"); // With no update, only the PostLoad is called
    tx.begin();
    em.refresh(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after refreshing");

    System.out.println("\nSET");
    tx.begin();
    customer.setFirstName("new first name");
    customer.setFirstName("new last name");
    tx.commit();

    // Merges the object
    System.out.println("\nMERGE");
    em.clear();
    assertFalse(em.contains(customer), "should not be in the persistence context after clearing");
    customer.setEmail("newone@mail.com"); // With no update, only the PostLoad is called
    tx.begin();
    customer = em.merge(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after merging");

    // Removes the entity
    System.out.println("\nREMOVE");
    tx.begin();
    em.remove(customer);
    tx.commit();
    assertFalse(em.contains(customer), "should not be in the persistence context after removing");
  }
}
