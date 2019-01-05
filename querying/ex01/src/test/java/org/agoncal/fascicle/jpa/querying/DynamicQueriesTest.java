package org.agoncal.fascicle.jpa.querying;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

  private static final int ALL_CUSTOMERS = 7;
  private static Customer customer01;
  private static Customer customer02;
  private static Customer customer03;
  private static Customer customer04;
  private static Customer customer05;
  private static Customer customer06;
  private static Customer customer07;

  @BeforeAll
  private static void initializeData() {
    customer01 = new Customer("Antony", "Balla", "tballa@mail.com", 14);
    Address address01 = new Address("Procession St", "Paris", "75015");
    Country country01 = new Country("FR");
    address01.setCountry(country01);
    customer01.setAddress(address01);

    customer02 = new Customer("Vincent", "Johnson", "vj@mail.com", 45);
    Address address02 = new Address("Ritherdon Rd", "London", "8QE");
    Country country02 = new Country("UK");
    address02.setCountry(country02);
    customer02.setAddress(address02);

    customer03 = new Customer("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address address03 = new Address("Inacio Alfama", "Lisbon", "A54");
    Country country03 = new Country("PT");
    address03.setCountry(country03);
    customer03.setAddress(address03);

    customer04 = new Customer("Frederic", "Riou", "fred@carmail.com", 41);
    Address address04 = new Address("Jardins", "Sao Paulo", "345678");
    Country country04 = new Country("BR");
    address04.setCountry(country04);
    customer04.setAddress(address04);

    customer05 = new Customer("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address address05 = new Address("Coffey", "Perth", "654F543");
    Country country05 = new Country("AU");
    address05.setCountry(country05);
    customer05.setAddress(address05);

    customer06 = new Customer("David", "Chene", "dch@yahoo.com", 89);
    Address address06 = new Address("Harbour Bridge", "Sydney", "JHG3");
    address06.setCountry(country05);
    customer06.setAddress(address06);

    customer07 = new Customer("Mike", "Pertus", "pertus@mike.com", 39);
    Address address07 = new Address("Playa de la Concha", "San Sebastian", "45678");
    Country country07 = new Country("ES");
    address07.setCountry(country07);
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
  }

  @AfterAll
  private static void removeData() {
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

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void adocQuery() throws Exception {
    // tag::adocQuery[]
    Query query = em.createQuery("SELECT c FROM Customer c");
    List<Customer> customers = query.getResultList();
    // end::adocQuery[]
    assertEquals(ALL_CUSTOMERS, customers.size());
  }

  @Test
  public void adocOneQuery() throws Exception {
    // tag::adocOneQuery[]
    Query query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = 'Mike'");
    Customer customer = (Customer) query.getSingleResult();
    // end::adocOneQuery[]
    assertEquals("Mike", customer.getFirstName());
  }

  @Test
  public void adocTypedQuery() throws Exception {
    // tag::adocTypedQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery("SELECT c FROM Customer c", Customer.class);
    List<Customer> customers = typedQuery.getResultList();
    // end::adocTypedQuery[]
    assertEquals(ALL_CUSTOMERS, customers.size());
  }

  @Test
  public void adocTypedOneQuery() throws Exception {
    // tag::adocTypedOneQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = 'Mike'", Customer.class);
    Customer customer = typedQuery.getSingleResult();
    // end::adocTypedOneQuery[]
    assertEquals("Mike", customer.getFirstName());
  }

  public void other() throws Exception {

    List<Customer> customers;

    Query query = em.createQuery("select c from Customer c");
    query.setMaxResults(3);
    assertEquals(3, query.getResultList().size());

    boolean someCriteria = true;
    // tag::adocQueryLine[]
    String jpqlQuery = "select c from Customer c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = 'Mike'";
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
    query.setParameter("fname", "Mike");
    customers = query.getResultList();
    // end::adocQueryParam[]
    assertEquals(1, customers.size());

    // tag::adocQueryParamNum[]
    query = em.createQuery("SELECT c FROM Customer c where c.firstName = ?1");
    query.setParameter(1, "Mike");
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
    assertEquals(ALL_CUSTOMERS, customers.size());

    // tag::adocQueryMax[]
    query = em.createQuery("SELECT c FROM Customer c", Customer.class);
    query.setMaxResults(5);
    customers = query.getResultList();
    // end::adocQueryMax[]
    assertEquals(5, customers.size());


    // TypedQuery
    // tag::adocTypedQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery("SELECT c FROM Customer c", Customer.class);
    customers = typedQuery.getResultList();
    // end::adocTypedQuery[]
    assertEquals(ALL_CUSTOMERS, customers.size());

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

  }
}

