/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

public class AddressTest {

  @Rule
  public WeldInitiator weld = WeldInitiator.from(new Weld())
    .activate(RequestScoped.class)
    .inject(this)
    .build();

  @Inject
  private AddressService addressService;

  @Test
  public void shouldCreateAnAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("12345");
    addressService.save(address);
    Assert.assertNotNull("ID should not be null", address.getId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldCreateAnInvalidAddress() throws Exception {

    Address address = new Address().street1("233 Spring Street").city("New York").zipcode("Invalid");
    addressService.save(address);
  }
}
