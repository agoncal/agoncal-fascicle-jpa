package org.agoncal.fascicle.jpa.puttingtogether;

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

    // 1-Creates an instance of book
    Book book = new Book().title("H2G2").price(12.5F).description("The Hitchhiker's Guide to the Galaxy").isbn("1-9754-742-3").nbOfPages(354).illustrations(true);


    // 2-Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    EntityManager em = emf.createEntityManager();

    // 3-Persists the book to the database
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(book);
    tx.commit();

    // 4-Executes the named query
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    System.out.println(book);

    // 5-Closes the entity manager and the factory
    em.close();
    emf.close();
  }
}
// end::adocSnippet[]
