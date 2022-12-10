/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
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
    props.put("javax.persistence.bean.manager", beanManager);
    return Persistence.createEntityManagerFactory("cdbookstorePU", props);
  }

  public void close(@Disposes EntityManagerFactory emf) {
    emf.close();
  }
}
// end::adocSnippet[]
