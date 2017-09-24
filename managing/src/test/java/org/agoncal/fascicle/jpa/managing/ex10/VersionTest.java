package org.agoncal.fascicle.jpa.managing.ex10;


import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
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
  public void shouldCreateABook() throws Exception {

    // Creates a book, version number should be 1
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 364, false);
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
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 364, false);
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

  @Test
  public void shouldReadThenLock() throws Exception {

    // Creates a book, version number should be 1
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 364, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
    assertEquals(new Integer(1), book.getVersion(), "Version number should be 1");

    // Reads then locks
    tx.begin();
    book = em.find(Book.class, book.getId());
    em.lock(book, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    book.raisePriceByTwoDollars();
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
    assertEquals(new Float(14.5), book.getPrice(), "Price shouls have been raise by 2 dollars");
  }

  @Test
  public void shouldReadAndLock() throws Exception {

    // Creates a book, version number should be 1
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 364, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
    assertEquals(new Integer(1), book.getVersion(), "Version number should be 1");

    // Reads then locks
    tx.begin();
    book = em.find(Book.class, book.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    book.raisePriceByTwoDollars();
    tx.commit();
    assertEquals(new Integer(2), book.getVersion(), "Version number should be 2");
    assertEquals(new Float(14.5), book.getPrice(), "Price shouls have been raise by 2 dollars");
  }
}
