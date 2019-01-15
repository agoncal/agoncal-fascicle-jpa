package org.agoncal.fascicle.jpa.puttingtogether;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.RollbackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest extends AbstractPersistentTest {

  @Test
  public void shouldCreateABook() throws Exception {

    // tag::shouldCreateABook[]
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    // end::shouldCreateABook[]
    assertNotNull(book.getId(), "ID should not be null");
  }

  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book().title("H2G2").price(12.5F).description("The Hitchhiker's Guide to the Galaxy").isbn("1-84023-742-3").nbOfPages(354).illustrations(true);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    Assertions.assertNotNull(book.getId(), "ID should not be null");

    // Retrieves all the books from the database
    List<Book> allBooks = em.createNamedQuery("findAllBooks", Book.class).getResultList();

    // Retrieves all the H2G2 books from the database
    List<Book> h2g2Books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
    assertEquals(1, h2g2Books.size());

    assertTrue(allBooks.size() >= h2g2Books.size());
  }

  @Test
  public void shouldCreateABookWithTagsAndChapters() throws Exception {

    // Creates an instance of book
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-4").nbOfPages(354);
    book.tag("java ee").tag("java").tag("enterprise");
    book.chapter(1, new Chapter().title("Bean Validation"));
    book.chapter(2, new Chapter().title("CDI"));
    book.chapter(3, new Chapter().title("JPA"));
    book.chapter(4, new Chapter().title("EJB"));

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");

    // Checks the book
    Book foundBook = em.find(Book.class, book.getId());
    assertEquals(3, foundBook.getTags().size());
    assertEquals(4, foundBook.getChapters().size());
  }

  @Test
  public void shouldCreateABookWithAnAuthor() throws Exception {

    // Creates an instance of book
    Author author = new Author().firstName("Antonio").lastName("Goncalves");
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-5").nbOfPages(354).author(author);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    em.persist(author);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");

    // Checks the book
    Book foundBook = em.find(Book.class, book.getId());
    assertEquals(1, foundBook.getAuthors().size());
  }

  @Test
  public void shouldFailCreatingABookButNotAuthor() throws Exception {

    // Creates an instance of book
    Author author = new Author().firstName("Antonio").lastName("Goncalves");
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-6").nbOfPages(354).author(author);

    // Persists the book to the database
    assertThrows(RollbackException.class, () -> {
      tx.begin();
      em.persist(book);
      tx.commit();
    });
  }

  @Test
  public void shouldFailCreatingTwoBooksWithSameISBN() throws Exception {

    Book book1 = new Book().title("Java EE 7").price(23.5F).isbn("1111").nbOfPages(354);
    Book book2 = new Book().title("Java EE 8").price(34.25F).isbn("1111").nbOfPages(482);

    // Persists the book to the database
    assertThrows(RollbackException.class, () -> {
      tx.begin();
      em.persist(book1);
      em.persist(book2);
      tx.commit();
    });
  }
}
// end::adocSnippet[]
