package org.agoncal.fascicle.jpa.integrating.jta;

import com.arjuna.ats.jta.utils.JNDIManager;
import org.jnp.server.NamingBeanImpl;
import org.junit.rules.ExternalResource;

public class JtaEnvironment extends ExternalResource {

  private NamingBeanImpl NAMING_BEAN;

  @Override
  protected void before() throws Throwable {
    NAMING_BEAN = new NamingBeanImpl();
    NAMING_BEAN.start();

    JNDIManager.bindJTAImplementation();
    TransactionalConnectionProvider.bindDataSource();
  }

  @Override
  protected void after() {
    NAMING_BEAN.stop();
  }
}
