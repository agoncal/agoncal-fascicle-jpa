/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.agoncal.fascicle.jpa.integrating.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

// tag::adocSnippet[]
@ApplicationScoped
public class EntityManagerFactoryProducer {

  @Inject
  private BeanManager beanManager;

  @Produces
  @ApplicationScoped
  public EntityManagerFactory produceEntityManagerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put("jakarta.persistence.bean.manager", beanManager);
    return Persistence.createEntityManagerFactory("vintageStorePU", props);
  }

  public void close(@Disposes EntityManagerFactory emf) {
    emf.close();
  }
}
// end::adocSnippet[]
