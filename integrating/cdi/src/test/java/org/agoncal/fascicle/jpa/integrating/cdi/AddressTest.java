package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
//@Disabled
//@EnableWeld
public class AddressTest {

  @Rule
  public WeldInitiator weld = WeldInitiator.from(AddressService.class)
    .activate(RequestScoped.class)
    .inject(this)
    .build();

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private AddressService addressService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");
//    tx.begin();
    addressService.save(address);
//    tx.commit();
    Assert.assertNotNull("ID should not be null", address.getId());
  }
}
