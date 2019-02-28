package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
