package org.agoncal.fascicle.jpa.integrating.jta;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {

  @Inject
  private EntityManagerFactory entityManagerFactory;

  @Produces
  @RequestScoped
  public EntityManager produceEntityManager() {
    return entityManagerFactory.createEntityManager();
  }

  public void close(@Disposes EntityManager entityManager) {
    entityManager.close();
  }
}
