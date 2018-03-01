package org.agoncal.fascicle.jpa.managing.ex04;


import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class DynamicQueriesTest extends AbstractPersistentTest {

  // ======================================
  // =              Constants             =
  // ======================================

  private static final int ALL = 7;

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldUseDynamicQuery() throws Exception {

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
    // tag::adocQuery[]
    Query query = em.createQuery("select c from Customer c");
    List<Customer> customers = query.getResultList();
    // end::adocQuery[]
    assertEquals(ALL, customers.size());

    query = em.createQuery("select c from Customer c");
    query.setMaxResults(3);
    assertEquals(3, query.getResultList().size());

    boolean someCriteria = true;
    // tag::adocQueryLine[]
    String jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = 'Betty'";
    query = em.createQuery(jpqlQuery);
    customers = query.getResultList();
    // end::adocQueryLine[]
    assertEquals(2, customers.size());

    jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = :fname";
    query = em.createQuery(jpqlQuery);
    query.setParameter("fname", "Vincent");
    assertEquals(2, query.getResultList().size());

    // tag::adocQueryParam[]
    query = em.createQuery("SELECT c FROM Customer c where c.firstName = :fname");
    query.setParameter("fname", "Betty");
    customers = query.getResultList();
    // end::adocQueryParam[]
    assertEquals(1, customers.size());

    // tag::adocQueryParamNum[]
    query = em.createQuery("SELECT c FROM Customer c where c.firstName = ?1");
    query.setParameter(1, "Betty");
    customers = query.getResultList();
    // end::adocQueryParamNum[]
    assertEquals(1, customers.size());

    jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = ?1";
    query = em.createQuery(jpqlQuery);
    query.setParameter(1, "Vincent");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer c  where c.firstName = :fname");
    query.setParameter("fname", "Vincent");
    query.setMaxResults(1);
    assertEquals(1, query.getResultList().size());

    query = em.createQuery("select c from Customer c  where c.firstName = :fname").setParameter("fname", "Vincent").setMaxResults(1);
    assertEquals(1, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c", Customer.class);
    customers = query.getResultList();
    assertEquals(ALL, customers.size());

    // tag::adocQueryMax[]
    query = em.createQuery("SELECT c FROM Customer c", Customer.class);
    query.setMaxResults(5);
    customers = query.getResultList();
    // end::adocQueryMax[]
    assertEquals(5, customers.size());


    // TypedQuery
    // tag::adocTypedQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery("select c from Customer c", Customer.class);
    customers = typedQuery.getResultList();
    // end::adocTypedQuery[]
    assertEquals(ALL, customers.size());

    typedQuery = em.createQuery("select c from Customer c", Customer.class);
    typedQuery.setMaxResults(3);
    assertEquals(3, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = 'Vincent'";
    typedQuery = em.createQuery(jpqlQuery, Customer.class);
    assertEquals(2, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = :fname";
    typedQuery = em.createQuery(jpqlQuery, Customer.class);
    typedQuery.setParameter("fname", "Vincent");
    assertEquals(2, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = ?1";
    typedQuery = em.createQuery(jpqlQuery, Customer.class);
    typedQuery.setParameter(1, "Vincent");
    assertEquals(2, typedQuery.getResultList().size());

    typedQuery = em.createQuery("select c from Customer c  where c.firstName = :fname", Customer.class);
    typedQuery.setParameter("fname", "Vincent");
    typedQuery.setMaxResults(1);
    assertEquals(1, typedQuery.getResultList().size());

    typedQuery = em.createQuery("select c from Customer c  where c.firstName = :fname", Customer.class).setParameter("fname", "Vincent").setMaxResults(1);
    assertEquals(1, typedQuery.getResultList().size());

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

