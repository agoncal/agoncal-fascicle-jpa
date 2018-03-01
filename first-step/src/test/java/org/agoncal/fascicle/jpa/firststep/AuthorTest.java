package org.agoncal.fascicle.jpa.firststep;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
  void shouldCreateAnAuthor() throws Exception {

    // tag::adocShouldRaiseNoConstraintViolation[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("wrong");
    tx.begin();
    em.persist(author);
    tx.commit();
    assertNotNull(author.getId(), "ID should not be null");
    // end::adocShouldRaiseNoConstraintViolation[]
  }
}
