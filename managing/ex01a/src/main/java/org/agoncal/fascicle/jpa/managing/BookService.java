package org.agoncal.fascicle.jpa.managing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Transactional
public class BookService {

  // Obtains an entity manager
  @PersistenceContext(unitName = "cdbookstorePU")
  private EntityManager em;

  public void createBook() {

    // Creates an instance of book
    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    em.persist(book);
  }
}
// end::adocSnippet[]
