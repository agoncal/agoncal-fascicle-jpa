package org.agoncal.fascicle.jpa.callbackslisteners;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class AgeCalculationListener {

  @PostLoad
  @PostPersist
  @PostUpdate
  public void calculateAge(Customer customer) {
    if (customer.getDateOfBirth() == null) {
      customer.setAge(null);
      return;
    }

    customer.setAge(Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears());
  }
}
// end::adocSnippet[]
