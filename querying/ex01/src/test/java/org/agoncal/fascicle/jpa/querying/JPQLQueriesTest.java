package org.agoncal.fascicle.jpa.querying;

import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class JPQLQueriesTest extends AbstractPersistentTest {

  // ======================================
  // =              Constants             =
  // ======================================

  private static final int ALL_CUSTOMERS = 7;
  private static final int ALL_BOOKS = 3;

  // ======================================
  // =              Unit tests            =
  // ======================================


  @Test
  public void shouldQueryBooks() throws Exception {

    Book book01 = new Book("H2G2", 12F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, "Apress");
    Book book02 = new Book("Java EE 6", 50F, "Learn about EE 6", "2-84023-742-2", 450, true, "Apress");
    Book book03 = new Book("Narcisse and Golmund", 10F, "One of the best Herman Hesse book", "3-84023-742-2", 153, false, "Pinguin");

    // Persist the object
    tx.begin();
    em.persist(book01);
    em.persist(book02);
    em.persist(book03);
    tx.commit();

    Query query = em.createQuery(
      // tag::adocSelectFromBook[]
      "SELECT b FROM Book b"
      // end::adocSelectFromBook[]
    );
    assertEquals(ALL_BOOKS, query.getResultList().size());

    query = em.createQuery(
      // tag::adocSelectFromBookH2G2[]
      "SELECT b FROM Book b WHERE b.title = 'H2G2'"
      // end::adocSelectFromBookH2G2[]
    );
    assertEquals(1, query.getResultList().size());

    // Remove objects
    tx.begin();
    em.remove(book01);
    em.remove(book02);
    em.remove(book03);
    tx.commit();
  }

  @Test
  public void shouldQueryCustomers() throws Exception {

    Customer customer01 = new Customer("Anthony", "Balla", "tballa@mail.com", 14);
    Address address01 = new Address("Procession St", "Paris", "75015");
    Country country01 = new Country("FR");
    address01.setCountry(country01);
    customer01.setAddress(address01);

    Customer customer02 = new Customer("Vincent", "Johnson", "vj@mail.com", 45);
    Address address02 = new Address("Ritherdon Rd", "London", "8QE");
    Country country02 = new Country("UK");
    address02.setCountry(country02);
    customer02.setAddress(address02);

    Customer customer03 = new Customer("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address address03 = new Address("Inacio Alfama", "Lisbon", "A54");
    Country country03 = new Country("PT");
    address03.setCountry(country03);
    customer03.setAddress(address03);

    Customer customer04 = new Customer("Frederic", "Riou", "fred@carmail.com", 41);
    Address address04 = new Address("Jardins", "Sao Paulo", "345678");
    Country country04 = new Country("BR");
    address04.setCountry(country04);
    customer04.setAddress(address04);

    Customer customer05 = new Customer("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address address05 = new Address("Coffey", "Perth", "654F543");
    Country country05 = new Country("AU");
    address05.setCountry(country05);
    customer05.setAddress(address05);

    Customer customer06 = new Customer("David", "Chene", "dch@yahoo.com", 89);
    Address address06 = new Address("Harbour Bridge", "Sydney", "JHG3");
    address06.setCountry(country05);
    customer06.setAddress(address06);

    Customer customer07 = new Customer("Mike", "Pertus", "pertus@mike.com", 39);
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

    // Select

    Query query = em.createQuery("SELECT c FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT c.firstName FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT c.firstName, c.lastName FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT c.address FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT c.address.country.code FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT NEW org.agoncal.fascicle.jpa.querying.CustomerDTO(c.firstName, c.lastName, c.address.country.code) FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT DISTINCT c FROM Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("SELECT DISTINCT c.firstName FROM Customer c");
    assertEquals(ALL_CUSTOMERS - 1, query.getResultList().size());

    query = em.createQuery("SELECT COUNT(c) FROM Customer c");
    assertEquals(new Long(ALL_CUSTOMERS), query.getSingleResult());

    // Where

    query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = 'Vincent' AND c.address.country.code = 'AU'");
    assertEquals(1, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.age > 18");
    assertEquals(5, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.age NOT BETWEEN 40 AND 50");
    assertEquals(5, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.address.country.code IN ('UK', 'FR')");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.email LIKE '%mail.com'");
    assertEquals(4, query.getResultList().size());

    // Binding

    query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = ?1 AND c.address.country.code = ?2");
    query.setParameter(1, "Vincent");
    query.setParameter(2, "AU");
    assertEquals(1, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = :fname AND c.address.country.code = :country");
    query.setParameter("fname", "Vincent");
    query.setParameter("country", "AU");
    assertEquals(1, query.getResultList().size());

    // Subqueries

    query = em.createQuery("SELECT c FROM Customer c WHERE c.age = (SELECT MIN(cust.age) FROM Customer cust)");
    assertEquals(2, query.getResultList().size());

    // Order By

    query = em.createQuery("SELECT c FROM Customer c WHERE c.age > 18 ORDER BY c.age DESC");
    assertEquals(5, query.getResultList().size());

    query = em.createQuery("SELECT c FROM Customer c WHERE c.age > 18 ORDER BY c.age DESC, c.address.country.code ASC");
    assertEquals(5, query.getResultList().size());

    // Group By and Having

    query = em.createQuery("SELECT c.address.country.code, COUNT(c) FROM Customer c GROUP BY c.address.country.code");
    assertEquals(6, query.getResultList().size());

    query = em.createQuery("SELECT c.address.country.code, COUNT(c) FROM Customer c GROUP BY c.address.country.code HAVING c.address.country.code <> 'UK'");
    assertEquals(5, query.getResultList().size());


    query = em.createQuery("SELECT NEW org.agoncal.fascicle.jpa.querying.CustomerDTO(c.firstName, c.lastName, c.address.country.code) from Customer c where c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select LOWER(c.firstName) from Customer c");
    assertEquals(ALL_CUSTOMERS, query.getResultList().size());

    query = em.createQuery("select c.address from Customer c where c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer c where c.address.country.code = 'AU'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select count(c) from Customer c where c.firstName = 'Vincent'");
    assertEquals(2L, query.getSingleResult());

    query = em.createQuery("select c from Customer c where c.age between 40 and 50");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select min(c.age) from Customer c");
    assertEquals(14, query.getSingleResult());

    tx.begin();
    query = em.createQuery("update Customer c set c.firstName = 'TOO YOUNG' where c.age < 18");
    assertEquals(2, query.executeUpdate());
    tx.commit();

    tx.begin();
    query = em.createQuery("delete from Customer c where c.age < 18");
    assertEquals(2, query.executeUpdate());
    tx.commit();

    // Remove objects
    tx.begin();
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer06);
    em.remove(customer07);
    tx.commit();
  }

  @Test
  public void shouldExecuteCaseQueries() throws Exception {

    Book book01 = new Book("The Hitchhiker's Guide to the Galaxy", 12F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, "Apress");
    Book book02 = new Book("Java EE 6", 50F, "Learn about EE 6", "2-84023-742-2", 450, true, "Apress");
    Book book03 = new Book("Narcisse and Golmund", 10F, "One of the best Herman Hesse book", "3-84023-742-2", 153, false, "Pinguin");

    // Persist the object
    tx.begin();
    em.persist(book01);
    em.persist(book02);
    em.persist(book03);
    tx.commit();

    Query query = em.createQuery("select b.price from Book b order by b.isbn");
    List<Float> prices = query.getResultList();
    assertEquals(3, prices.size());
    assertEquals(new Float(12F), prices.get(0));
    assertEquals(new Float(50F), prices.get(1));
    assertEquals(new Float(10F), prices.get(2));

    query = em.createQuery("SELECT CASE b.editor WHEN 'Apress' THEN b.price * 0.5 ELSE b.price * 0.8 END FROM Book b");
    prices = query.getResultList();
    assertEquals(3, prices.size());
    assertEquals(new Double(6), prices.get(0), "12 * 0.5 = 6");
    assertEquals(new Double(25), prices.get(1), "50 * 0.5 = 25");
    assertEquals(new Double(8), prices.get(2), "10 * 0.8 = 8");

    // Remove objects
    tx.begin();
    em.remove(book01);
    em.remove(book02);
    em.remove(book03);
    tx.commit();
  }
}

