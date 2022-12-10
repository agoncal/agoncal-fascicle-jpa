package org.agoncal.fascicle.jpa.integrating.beanvalidation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.sql.SQLException;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  protected EntityManager em;
  protected EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeEach
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterEach
  public void closeEntityManager() throws SQLException {
    if (em != null) em.close();
  }
}
