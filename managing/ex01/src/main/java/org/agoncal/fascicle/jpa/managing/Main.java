package org.agoncal.fascicle.jpa.managing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Main {

  public static void main(String[] args) {

    // Obtains an entity manager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    EntityManager em = emf.createEntityManager();

    // Obtains a transaction
    EntityTransaction tx = em.getTransaction();

    // Creates an instance of book
    Book book = new Book().title("H2G2").description("The Hitchhiker's Guide to the Galaxy").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();

    // Closes the entity manager and the factory
    em.close();
    emf.close();
  }
}
// end::adocSnippet[]
