package org.agoncal.fascicle.jpa.integrating.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

// tag::adocSnippet[]
@ApplicationScoped
public class EntityManagerProducer {

  @Inject
  private EntityManagerFactory emf;

  @Produces
  @RequestScoped
  public EntityManager produceEntityManager() {
    return emf.createEntityManager();
  }

  public void close(@Disposes EntityManager em) {
    em.close();
  }
}
// end::adocSnippet[]
