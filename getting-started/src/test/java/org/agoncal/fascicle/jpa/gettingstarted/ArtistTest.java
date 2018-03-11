package org.agoncal.fascicle.jpa.gettingstarted;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  private static EntityManager em;
  private static EntityTransaction tx;

  @BeforeAll
  static void init() {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  static void close() {
    if (em != null) em.close();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldCreateAnArtist() {

    // tag::shouldCreateAnArtist[]
    Artist artist = new Artist().firstName("Adams").lastName("Douglas");
    tx.begin();
    em.persist(artist);
    tx.commit();
    assertNotNull(artist.getId(), "ID should not be null");
    // end::shouldCreateAnArtist[]
  }

  @Test
  void shouldNotCreateAnArtistWithNullFirstname() {

    // tag::shouldNotCreateAnArtistWithNullFirstname[]
    Artist artist = new Artist().firstName(null);
    tx.begin();
    em.persist(artist);
    assertThrows(RollbackException.class, () -> {
      tx.commit();
    });
    // end::shouldNotCreateAnArtistWithNullFirstname[]
  }
}
