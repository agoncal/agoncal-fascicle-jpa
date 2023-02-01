package org.agoncal.fascicle.jpa.integrating.jta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {

  @Inject
  private EntityManagerFactory emf;

  @Produces
  @ApplicationScoped
  public EntityManager produceEntityManager() {
    return emf.createEntityManager();
  }

  public void close(@Disposes EntityManager em) {
    em.close();
  }
}
