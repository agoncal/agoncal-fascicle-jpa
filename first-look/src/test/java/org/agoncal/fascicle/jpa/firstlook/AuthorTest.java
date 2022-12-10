package org.agoncal.fascicle.jpa.firstlook;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorTest {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
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
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldCreateAnAuthor() {

    // tag::adocShouldCreateAnAuthor[]
    Author author = new Author().firstName("Adams").lastName("Douglas");
    assertNull(author.getId(), "Id should be null");

    tx.begin();
    em.persist(author);
    tx.commit();

    assertNotNull(author.getId(), "Id should not be null");
    // end::adocShouldCreateAnAuthor[]
  }

  @Test
  void shouldNotCreateAnAuthorWithNullFirstname() {

    // tag::adocShouldNotCreateAnAuthorWithNullFirstname[]
    Author author = new Author().firstName(null);

    tx.begin();
    em.persist(author);
    assertThrows(RollbackException.class, () -> tx.commit());
    // end::adocShouldNotCreateAnAuthorWithNullFirstname[]
  }
}
