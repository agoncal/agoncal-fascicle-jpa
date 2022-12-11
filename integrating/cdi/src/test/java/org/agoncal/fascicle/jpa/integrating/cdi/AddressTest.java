package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

  @Rule
  public WeldInitiator weld = WeldInitiator.from(new Weld())
    .activate(RequestScoped.class)
    .inject(this)
    .build();

  @Inject
  private EntityManager entityManager;

  @Inject
  private AddressService addressService;

  @Test
  public void shouldCreateAnAddress() {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("12345");
    addressService.save(address);
    Assert.assertNotNull("Id should not be null", address.getId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldCreateAnInvalidAddress() {
    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("Invalid");
    addressService.save(address);
  }

  @Test
  public void shoudInjectEntityManager() {
    assertThat(entityManager).isNotNull();
  }
}
