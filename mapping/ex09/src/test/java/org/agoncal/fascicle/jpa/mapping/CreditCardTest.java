package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import static org.agoncal.fascicle.jpa.mapping.CreditCardType.AMERICAN_EXPRESS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCardTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateACreditCard() throws Exception {

    CreditCard creditCard = new CreditCard("123412341234", "12/12", 1253, AMERICAN_EXPRESS);
    tx.begin();
    em.persist(creditCard);
    tx.commit();
    assertNotNull(creditCard.getNumber(), "ID should not be null");
    assertEquals(AMERICAN_EXPRESS, creditCard.getType(), "Should be American Express");
  }
}
