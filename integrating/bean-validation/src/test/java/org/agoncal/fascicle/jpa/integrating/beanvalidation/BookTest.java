package org.agoncal.fascicle.jpa.integrating.beanvalidation;

import org.junit.jupiter.api.Test;

import javax.persistence.RollbackException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateAValidBook() throws Exception {

    // tag::shouldCreateAValidBook[]
    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    tx.begin();
    em.persist(book);
    tx.commit();
    // end::shouldCreateAValidBook[]
    assertNotNull(book.getId(), "ID should not be null");
  }

  @Test
  public void shouldRaiseConstraintViolationCauseNullTitle() {

    // tag::shouldRaiseConstraintViolationCauseNullTitle[]
    Book book = new Book().title(null).price(12.5F).isbn("1-84023-742-2").nbOfPages(354);
    assertThrows(RollbackException.class, () -> {
      tx.begin();
      em.persist(book);
      tx.commit();
    });
    // end::shouldRaiseConstraintViolationCauseNullTitle[]
  }
}
