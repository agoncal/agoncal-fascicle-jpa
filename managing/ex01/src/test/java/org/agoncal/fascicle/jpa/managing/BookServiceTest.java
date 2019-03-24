package org.agoncal.fascicle.jpa.managing;

import org.junit.jupiter.api.Test;

/**
 * @book Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookServiceTest {

  @Test
  void shouldCreateABook() {
    BookService bookService = new BookService();
    bookService.createBook();
  }
}
