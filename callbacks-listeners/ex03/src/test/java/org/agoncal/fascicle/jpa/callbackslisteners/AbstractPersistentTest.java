package org.agoncal.fascicle.jpa.callbackslisteners;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  protected static EntityManager em;
  protected static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public static void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  public static void closeEntityManager() throws SQLException {
    if (em != null) em.close();
  }

  protected Long getRandomId() {
    return Math.abs(new Random().nextLong());
  }
}
