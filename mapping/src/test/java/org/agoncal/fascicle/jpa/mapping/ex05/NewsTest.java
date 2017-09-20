package org.agoncal.fascicle.jpa.mapping.ex05;


import org.agoncal.fascicle.jpa.mapping.AbstractPersistentTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 * Test class that creates a News (using the EmbeddedId annotation)
 */
public class NewsTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateANews() throws Exception {

    News news = new News(new NewsId("Richard Wright has died", "EN"), "The keyboard of Pink Floyd has died today");
    tx.begin();
    em.persist(news);
    tx.commit();

    news = em.find(News.class, new NewsId("Richard Wright has died", "EN"));

    assertEquals("The keyboard of Pink Floyd has died today", news.getContent());
  }
}
