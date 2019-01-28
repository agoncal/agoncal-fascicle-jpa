package org.agoncal.fascicle.jpa.mapping;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
  public void shouldCreateABook() throws Exception {

    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "Id should not be null");
  }

  @Test
  @Disabled("updatable = false does not work")
  public void titleShouldNotBeUpdatable() throws Exception {

    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "Id should not be null");
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());

    tx.begin();
    book = em.find(Book.class, book.getId());
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());
    book.setTitle("H2G2");
    assertEquals("Title should be H2G2", "H2G2", book.getTitle());
    tx.commit();

    tx.begin();
    book = em.find(Book.class, book.getId());
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());
    tx.commit();
  }
}
