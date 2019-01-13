package org.agoncal.fascicle.jpa.integrating.beanvalidation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

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
    // Creates an instance of book
    Book book = new Book().title("H2G2").description("The Hitchhiker's Guide to the Galaxy").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
  }

  @Test
  public void shouldRaiseConstraintViolationCauseNullTitle() {

    // tag::shouldRaiseConstraintViolationCauseNullTitle[]
    Book book = new Book().title(null).price(12.5F).isbn("1-84023-742-2").nbOfPages(354);
    assertThrows(ConstraintViolationException.class, () -> {
      tx.begin();
      em.persist(book);
      tx.commit();
    });
    // end::shouldRaiseConstraintViolationCauseNullTitle[]
  }
}
