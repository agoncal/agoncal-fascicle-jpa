package org.agoncal.fascicle.jpa.puttingtogether;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class BookTest {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  private EntityManager em;
  private EntityTransaction tx;

  @BeforeEach
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterEach
  public void closeEntityManager() throws Exception {
    if (em != null) em.close();
  }

  @Test
  public void shouldFindJavaEE7Book() throws Exception {
    Book book = em.find(Book.class, 1001L);
    assertEquals("Beginning Java EE 7", book.getTitle());
  }

  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    Assertions.assertNotNull(book.getId(), "ID should not be null");

    // Retrieves all the books from the database
    List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
    assertEquals(1, books.size());
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
  }

  @Test // TODO (expected = ConstraintViolationException.class)
  public void shouldRaiseConstraintViolationCauseNullTitle() {

    Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
    em.persist(book);
  }
}
// end::adocSnippet[]
