package org.agoncal.fascicle.jpa.advanced;



import org.junit.jupiter.api.Test;

import javax.persistence.LockModeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class VersionTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void adocReadThenLock() throws Exception {

    // Creates a book, version number should be 1
    Book b = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2");
    tx.begin();
    em.persist(b);
    tx.commit();
    assertNotNull(b.getId(), "ID should not be null");
    assertEquals(new Integer(1), b.getVersion(), "Version number should be 1");
    Long id = b.getId();

    tx.begin();
    // tag::adocReadThenLock[]
    // Reads the entity
    Book book = em.find(Book.class, id);

    // Then locks the entity
    em.lock(book, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

    book.raisePriceByTwoDollars();
    // end::adocReadThenLock[]
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
    assertEquals(new Float(14.5), book.getPrice(), "Price shouls have been raise by 2 dollars");
  }

  @Test
  public void adocReadAndLock() throws Exception {

    // Creates a book, version number should be 1
    Book b = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2");
    tx.begin();
    em.persist(b);
    tx.commit();
    assertNotNull(b.getId(), "ID should not be null");
    assertEquals(new Integer(1), b.getVersion(), "Version number should be 1");
    Long id = b.getId();

    // Reads then locks
    tx.begin();
    // tag::adocReadAndLock[]
    // Reads and locks the entity
    Book book = em.find(Book.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

    book.raisePriceByTwoDollars();
    // end::adocReadAndLock[]
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
    assertEquals(new Float(14.5), book.getPrice(), "Price shouls have been raise by 2 dollars");
  }

  @Test
  public void shouldCreateABook() throws Exception {

    // Creates a book, version number should be 1
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2");
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
    assertEquals(new Integer(1), book.getVersion(), "Version number should be 1");

    // Updates the same book
    tx.begin();
    book = em.find(Book.class, book.getId());
    book.setDescription("new description");
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
  }

  @Test
  public void shouldCreateABookAndRaisePrice() throws Exception {

    // Creates a book, version number should be 1
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2");
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
    assertEquals(new Integer(1), book.getVersion(), "Version number should be 1");

    // Updates the same book
    tx.begin();
    book.raisePriceByTwoDollars();
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
  }
}
