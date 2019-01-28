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
    assertNotNull(creditCard.getNumber(), "Id should not be null");

    String dbCreditCardType = (String) em.createNativeQuery("select creditCardType from CreditCard where number = '123412341234'").getSingleResult();
    assertEquals("A", dbCreditCardType, "Should be A for American Express");
  }
}
