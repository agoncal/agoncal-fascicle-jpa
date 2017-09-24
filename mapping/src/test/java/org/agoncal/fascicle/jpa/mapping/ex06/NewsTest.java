package org.agoncal.fascicle.jpa.mapping.ex06;

import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class NewsTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateANews() throws Exception {

    News news = new News("Richard Wright has died", "EN", "The keyboard of Pink Floyd has died today");
    tx.begin();
    em.persist(news);
    tx.commit();
    assertNotNull(news.getTitle(), "ID should not be null");
  }
}
