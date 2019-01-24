package org.agoncal.fascicle.jpa.integrating.cdi;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Environment;

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
                "myPu",
                props
        );
    }

    public void close(@Disposes EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
    }
}
