package org.agoncal.fascicle.jpa.managing.ex01;

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

    // Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

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
