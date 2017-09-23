package org.agoncal.fascicle.jpa.managing.ex01;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Transactional
public class BookService {

  // Obtains an entity manager and a transaction
  @PersistenceContext(unitName = "cdbookstorePU")
  private EntityManager em;

  public void createBook() {

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    em.persist(book);
  }
}
// end::adocsnippet[]
