package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
  public void shouldCreateABookWithTags() throws Exception {

    ArrayList<String> tags = new ArrayList<>();
    tags.add("scifi");
    tags.add("must have");
    tags.add("funny");
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, tags);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");
    assertEquals(3, book.getTags().size());
  }
}
