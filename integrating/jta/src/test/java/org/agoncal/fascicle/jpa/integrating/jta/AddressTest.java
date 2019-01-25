package org.agoncal.fascicle.jpa.integrating.jta;

import org.assertj.core.api.Assertions;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class AddressTest {

    @ClassRule
    public static JtaEnvironment jtaEnvironment = new JtaEnvironment();

    @Rule
    public WeldInitiator weld = WeldInitiator.from(new Weld())
            .activate(RequestScoped.class)
            .inject(this)
            .build();

    // new Weld() above enables scanning of the classpath; alternatively, only the required beans can be listed explicitly:

//    @Rule
//    public WeldInitiator weld = WeldInitiator.from(
//            ObserverTestBean.class,
//            TransactionalTestService.class,
//            AddressService.class,
//            EntityManagerProducer.class,
//            EntityManagerFactoryProducer.class,
//            TransactionExtension.class
//        )
//        .activate(RequestScoped.class)
//        .inject(this)
//        .build();

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction ut;

    @Inject
    private AddressService addressService;

    @Inject
    private TransactionalTestService transactionalTestService;

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("12345");
    addressService.save(address);
    Assert.assertNotNull("ID should not be null", address.getId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldCreateAnInvalidAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("Invalid");
//    assertThrows(IllegalArgumentException.class, () -> {
      addressService.save(address);
//    });

  }

  @Test
    public void canInjectEntityManager() {
        assertThat(entityManager).isNotNull();

        entityManager.getTransaction().begin();

        Address te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 1");
        entityManager.persist(te);

        te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 2");
        entityManager.persist(te);

        entityManager.getTransaction().commit();
        entityManager.clear();

        entityManager.getTransaction().begin();
        List<Address> loaded = entityManager.createQuery("FROM Address te", Address.class).getResultList();
        Assertions.assertThat(loaded).hasSize(2);
        entityManager.getTransaction().commit();
    }

    @Test
    public void canInjectUserTransaction() throws Exception {
        assertThat(ut).isNotNull();

        ut.begin();

        Address te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 1");
        entityManager.persist(te);

        te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 2");
        entityManager.persist(te);

        ut.commit();
        entityManager.clear();

        ut.begin();
        List<Address> loaded = entityManager.createQuery("FROM Address te", Address.class).getResultList();
        Assertions.assertThat(loaded).hasSize(2);
        ut.commit();
    }

    //@Test
    public void canUseDiInEntityListener() {
        entityManager.getTransaction().begin();

        Address te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 1");
        entityManager.persist(te);

        te = new Address();
        //te.setId(UUID.randomUUID());
        te.setStreet1("Test 2");
        entityManager.persist(te);

        entityManager.getTransaction().commit();

        assertThat(addressService.getTestEntityNames()).contains("Test 1", "Test 2");
    }

    @Test
    public void canUseDeclarativeTxControl() throws Exception {
        try {
            transactionalTestService.doSomething();
            fail("Exception raised due to missing yet required transaction wasn't raised");
        }
        catch(TransactionalException e) {
            assertThat(e.getMessage().contains("ARJUNA016110"));
        }

        ut.begin();
        assertThat(transactionalTestService.doSomething()).isEqualTo("Success");
        ut.rollback();
    }
}
