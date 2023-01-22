package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CDTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateACD() throws Exception {

    CD cd = new CD("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
    tx.begin();
    em.persist(cd);
    tx.commit();
    assertNotNull(cd.getId(), "Id should not be null");
  }
}
