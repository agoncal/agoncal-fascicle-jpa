package org.agoncal.fascicle.jpa.understanding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @book Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vintageStorePU");
  private static EntityManager em;
  private static EntityTransaction tx;

  @BeforeAll
  static void init() {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  static void close() {
    if (em != null) em.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldCreateABook() {

    Book book = new Book().title("H2G2");
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "Id should not be null");
  }
}
