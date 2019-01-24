package org.agoncal.fascicle.jpa.integrating.jta;

import org.jboss.weld.context.bound.BoundRequestContext;

import javax.enterprise.inject.se.SeContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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


}
