package org.agoncal.fascicle.jpa.querying;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CriteriaQueriesTest extends AbstractPersistentTest {

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
    customer01 = new Customer("Anthony", "Balla", "tballa@mail.com", 14);
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
  public void adocNoWhere() throws Exception {
    // tag::adocNoWhere[]
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> customer = criteriaQuery.from(Customer.class);
    criteriaQuery.select(customer);

    TypedQuery<Customer> query = em.createQuery(criteriaQuery);
    List<Customer> customers = query.getResultList();
    // end::adocNoWhere[]
    assertEquals(ALL_CUSTOMERS, customers.size());
  }

  @Test
  public void adocWhere() throws Exception {
    // tag::adocWhere[]
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> c = criteriaQuery.from(Customer.class);
    criteriaQuery.select(c).where(builder.equal(c.get("firstName"), "Vincent"));

    TypedQuery<Customer> query = em.createQuery(criteriaQuery);
    List<Customer> customers = query.getResultList();
    // end::adocWhere[]
    assertEquals(2, customers.size());
  }

  @Test
  public void adocWhereBindParameter() throws Exception {
    // tag::adocWhere[]
    String param = "Vincent";

    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> c = criteriaQuery.from(Customer.class);
    criteriaQuery.select(c).where(builder.equal(c.get("firstName"), param));

    TypedQuery<Customer> query = em.createQuery(criteriaQuery);
    List<Customer> customers = query.getResultList();
    // end::adocWhere[]
    assertEquals(2, customers.size());
  }

  @Test
  public void adocAge() throws Exception {
    // tag::adocAge[]
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> c = criteriaQuery.from(Customer.class);
    criteriaQuery.select(c).where(builder.greaterThan(c.get("age").as(Integer.class), 40));

    TypedQuery<Customer> query = em.createQuery(criteriaQuery);
    List<Customer> customers = query.getResultList();
    // end::adocAge[]
    assertEquals(4, customers.size());
  }

  @Test
  public void adocAgeTypeSafe() throws Exception {
    // tag::adocAgeTypeSafe[]
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
    Root<Customer> c = criteriaQuery.from(Customer.class);
    criteriaQuery.select(c).where(builder.greaterThan(c.get(Customer_.age), 40));

    TypedQuery<Customer> query = em.createQuery(criteriaQuery);
    List<Customer> customers = query.getResultList();
    // end::adocAgeTypeSafe[]
    assertEquals(4, customers.size());
  }
}

