package org.agoncal.fascicle.jpa.understanding.ex01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocsnippet[]
public class Main {

  public static void main(String[] args) {

    // 1-Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // 2-Obtains an entity manager and a transaction
    // tag::adocfactory[]
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
    EntityManager em = emf.createEntityManager();
    // end::adocfactory[]

    // 3-Persists the book to the database
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    // tag::adocpersist[]
    em.persist(book);
    // end::adocpersist[]
    tx.commit();

    // 4-Executes the named query
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();

    System.out.println("######### " + book.getDescription());

    // 5-Closes the entity manager and the factory
    em.close();
    emf.close();
  }
}
// end::adocsnippet[]
