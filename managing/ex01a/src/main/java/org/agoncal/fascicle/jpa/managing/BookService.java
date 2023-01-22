package org.agoncal.fascicle.jpa.managing;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Transactional
public class BookService {

  // Obtains an entity manager
  @PersistenceContext(unitName = "vintageStorePU")
  private EntityManager em;

  public void createBook() {

    // Creates an instance of book
    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    em.persist(book);
  }
}
// end::adocSnippet[]
