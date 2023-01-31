package org.agoncal.fascicle.jpa.integrating.cdi;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld
@AddPackages(Address.class)
public class AddressTest {

//  @ExtendWith(WeldJunit5Extension.class)
//  public WeldInitiator weld = WeldInitiator.from(new Weld())
//    .activate(RequestScoped.class)
//    .inject(this)
//    .build();

  @Inject
  private EntityManager entityManager;

  @Inject
  private AddressService addressService;

  @Test
  public void shouldCreateAnAddress() {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("12345");
    addressService.save(address);
    Assertions.assertNotNull(address.getId(), "Id should not be null");
  }

  @Test
  public void shouldCreateAnInvalidAddress() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Address address = new Address().street1("233 Spring Street").city("New York").zipcode("Invalid");
      addressService.save(address);
    });
  }

  @Test
  public void shoudInjectEntityManager() {
    assertThat(entityManager).isNotNull();
  }
}
