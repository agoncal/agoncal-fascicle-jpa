package org.agoncal.fascicle.jpa.integrating.jta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
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
