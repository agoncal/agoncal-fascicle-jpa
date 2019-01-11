package org.agoncal.fascicle.jpa.managing.ex07;


import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class NativeQueriesTest extends AbstractPersistentTest {

  // ======================================
  // =              Constants             =
  // ======================================

  private static final int ALL = 7;

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldFindAllWithANativeQueries() throws Exception {

    Customer customer01 = new Customer("Antony", "Balla", "tballa@mail.com", 14);
    Address address01 = new Address("Procession St", "Paris", "75015", "FR");
    customer01.setAddress(address01);

    Customer customer02 = new Customer("Vincent", "Johnson", "vj@mail.com", 45);
    Address address02 = new Address("Ritherdon Rd", "London", "8QE", "UK");
    customer02.setAddress(address02);

    Customer customer03 = new Customer("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address address03 = new Address("Inacio Alfama", "Lisbon", "A54", "PT");
    customer03.setAddress(address03);

    Customer customer04 = new Customer("Frederic", "Riou", "fred@carmail.com", 41);
    Address address04 = new Address("Jardins", "Sao Paulo", "345678", "BR");
    customer04.setAddress(address04);

    Customer customer05 = new Customer("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address address05 = new Address("Coffey", "Perth", "654F543", "AU");
    customer05.setAddress(address05);

    Customer customer06 = new Customer("David", "Chene", "dch@yahoo.com", 89);
    Address address06 = new Address("Harbour Bridge", "Sydney", "JHG3", "AU");
    customer06.setAddress(address06);

    Customer customer07 = new Customer("Betty", "Moreau", "bty@more.com", 39);
    Address address07 = new Address("Playa de la Concha", "San Sebastian", "45678", "ES");
    customer07.setAddress(address07);

    // Persist the object
    tx.begin();
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    em.persist(customer07);
    tx.commit();

    // Query
    Query query = em.createNativeQuery("select * from t_customer", Customer.class);
    List<Customer> customers = query.getResultList();
    assertEquals(ALL, customers.size());

//        query = em.createNativeQuery("findAllNative");
//        customers = query.getResultList();
//        assertEquals(ALL, customers.size());
//
//        query = em.createNativeQuery("select lastname from JPQL_EX01_CUSTOMER", String.class);
//        List<String> customersNames = query.getResultList();
//        assertEquals(ALL, customersNames.size());

    // Remove objects
    tx.begin();
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    em.remove(customer07);
    tx.commit();
  }
}

