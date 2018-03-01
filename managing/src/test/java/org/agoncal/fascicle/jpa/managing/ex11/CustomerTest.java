package org.agoncal.fascicle.jpa.managing.ex11;


import org.agoncal.fascicle.jpa.managing.AbstractPersistentTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void ageShouldBeGretaterThanZero() {
    Customer customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com", "+351 123 4565");
    customer.setDateOfBirth(new GregorianCalendar(1975, 5, 27).getTime());

    customer.calculateAge();

    int calculatedAge = customer.getAge();

    assertTrue(calculatedAge >= 0);
  }

  @Test
  public void ageShouldBe33() {
    int expectedAge = 33;

    Calendar birth = new GregorianCalendar();
    birth.roll(Calendar.YEAR, expectedAge * (-1));
    birth.roll(Calendar.DAY_OF_YEAR, -1);

    Customer customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com", "+351 123 4565");
    customer.setDateOfBirth(birth.getTime());

    customer.calculateAge();

    assertEquals(new Long(expectedAge), new Long(customer.getAge()));
  }

  @Test
  public void shouldCheckAgeIsNullCauseDateOfBirtheIsNull() {
    Customer customer = new Customer();
    customer.calculateAge();
    assertNull(customer.getAge());
  }

  @Disabled("Test is not ready yet")
  @Test
  public void shouldCalculateOldAge() {
    // some work to do
  }

  @Test
  public void shouldCheckTheAgeOfTheCustomer() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    assertFalse(em.contains(customer));

    // Persists the object
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after persisting");
    assertEquals(new Integer(0), customer.getAge());

    // Finds the object
    customer = em.find(Customer.class, customer.getId());
    assertTrue(em.contains(customer), "should be in the persistence context after finding");
    assertEquals(new Integer(0), customer.getAge());

    // Removes the entity
    tx.begin();
    em.remove(customer);
    tx.commit();
    assertFalse(em.contains(customer), "should not be in the persistence context after removing");
  }

  @Test //(expected = IllegalArgumentException.class)
  public void shouldThrowAnExceptionBecauseFirstNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer(null, "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();
  }

  @Test //(expected = IllegalArgumentException.class)
  public void shouldThrowAnExceptionBecauseLastNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", null, "jsmith@gmail.com", "1234565", new Date(), new Date());

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();
  }
}
