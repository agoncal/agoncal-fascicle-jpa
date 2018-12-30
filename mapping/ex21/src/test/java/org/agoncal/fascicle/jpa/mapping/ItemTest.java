package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ItemTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateSeveralItems() throws Exception {

    Item item = new Item("Junk", 52.50f, "A piece of junk");
    CD cd01 = new CD("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
    CD cd02 = new CD("Love SUpreme", 20f, "John Coltrane love moment", "Blue Note", 2, 87.45f, "Jazz");
    Book book01 = new Book("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
    Book book02 = new Book("The Robots of Dawn", 37.5f, "Robots, again and again", "0-553-29949-2 ", "Foundation", 264, true);
    tx.begin();
    em.persist(item);
    em.persist(cd01);
    em.persist(cd02);
    em.persist(book01);
    em.persist(book02);
    tx.commit();
    assertNotNull(item.getId(), "Item ID should not be null");
    assertNotNull(cd01.getId(), "CD1 ID should not be null");
    assertNotNull(cd02.getId(), "CD2 ID should not be null");
    assertNotNull(book01.getId(), "Book1 ID should not be null");
    assertNotNull(book02.getId(), "Book2 ID should not be null");
  }
}
