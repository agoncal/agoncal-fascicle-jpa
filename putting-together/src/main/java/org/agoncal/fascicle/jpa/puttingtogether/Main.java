package org.agoncal.fascicle.jpa.puttingtogether;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Main {

  public static void main(String[] args) {

    // 1 - Creates an instance of book with tags
    Book book = new Book().title("H2G2").price(12.5F).isbn("1-9754-742-3").nbOfPages(354);
    book.tag("sci-fi").tag("fun").tag("geek");

    // 2 - Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("vintageStorePU");
    EntityManager em = emf.createEntityManager();

    // 3 - Persists the book to the database
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(book);
    tx.commit();

    // 4 - Queries H2G2 books
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    System.out.println(book);

    // 4 - Queries all the books
    int books = em.createNamedQuery("findAllBooks", Book.class).getResultList().size();
    System.out.println("Number of books " + books);

    // 5 - Closes the entity manager and the factory
    em.close();
    emf.close();
  }
}
// end::adocSnippet[]
