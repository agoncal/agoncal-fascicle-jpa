package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;

public class EntityManagerFactoryProducer {

  @Inject
  private BeanManager beanManager;

  @Produces
  @ApplicationScoped
  public EntityManagerFactory produceEntityManagerFactory() {
    return Persistence.createEntityManagerFactory("cdbookstorePU",
      Collections.singletonMap("javax.persistence.bean.manager", beanManager)
    );
  }

  public void close(@Disposes EntityManagerFactory entityManagerFactory) {
    entityManagerFactory.close();
  }}
