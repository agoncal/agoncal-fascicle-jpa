package org.agoncal.fascicle.jpa.integrating.jta;

import org.hibernate.cfg.Environment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EntityManagerFactoryProducer {

  @Inject
  private BeanManager beanManager;

  @Produces
  @ApplicationScoped
  public EntityManagerFactory produceEntityManagerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put("jakarta.persistence.bean.manager", beanManager);
    props.put(Environment.CONNECTION_PROVIDER, TransactionalConnectionProvider.class);
    return Persistence.createEntityManagerFactory(
      "cdbookstorePU",
      props
    );
  }

  public void close(@Disposes EntityManagerFactory entityManagerFactory) {
    entityManagerFactory.close();
  }
}
