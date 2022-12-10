package org.agoncal.fascicle.jpa.integrating.jta;

import org.hibernate.cfg.Environment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
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
    props.put("javax.persistence.bean.manager", beanManager);
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
