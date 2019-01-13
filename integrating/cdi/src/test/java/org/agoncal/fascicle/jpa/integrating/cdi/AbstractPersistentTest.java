package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.context.bound.BoundRequestContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class AbstractPersistentTest {

  private static SeContainer seContainer;

  @Inject
  BoundRequestContext requestContext;

  private Map<String, Object> requestDataStore;

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  protected EntityManager em;
  protected EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public static void startCdiContainer() {
    seContainer = SeContainerInitializer.newInstance()
      .addBeanClasses(EntityManagerFactoryProducer.class, EntityManagerProducer.class)
//      .addBeanClasses(ZipCodeListener.class, ZipCodeChecker.class)
      .initialize();
  }

  @AfterAll
  public static void stopCdiContainer() {
    seContainer.close();
  }

  @BeforeEach
  public <T> void injectTestAndStartRequestScope() {
    BeanManager beanManager = seContainer.getBeanManager();
    AnnotatedType<T> at = (AnnotatedType<T>) beanManager.createAnnotatedType(getClass());
    CreationalContext<T> ctx = beanManager.createCreationalContext(null);
    beanManager.createInjectionTarget(at).inject((T)this, ctx);

    requestDataStore = new HashMap<String, Object>();
    requestContext.associate(requestDataStore);
    requestContext.activate();
  }

  @AfterEach
  public void stopRequestScope() {
    try {
      requestContext.invalidate();
      requestContext.deactivate();

    }
    finally {
      requestContext.dissociate(requestDataStore);
    }
  }

//  @BeforeEach
//  public void initEntityManager() throws Exception {
//    em = emf.createEntityManager();
//    tx = em.getTransaction();
//  }
//
//  @AfterEach
//  public void closeEntityManager() throws SQLException {
//    if (em != null) em.close();
//  }
//
//  protected Long getRandomId() {
//    return Math.abs(new Random().nextLong());
//  }
}
