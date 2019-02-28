package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  public void shouldCreateOneNewsWithFourComments() throws Exception {

    News news = new News("Death of Michael Jackson");
    Comment comment1 = new Comment("gonzo", "Third comment", 1, "2009-07-03 11:01:20");
    Comment comment2 = new Comment("elvis", "First comment", 3, "2009-07-01 11:01:20");
    Comment comment3 = new Comment("gonzo", "Second comment", 5, "2009-07-02 11:01:20");
    Comment comment4 = new Comment("elvis", "Fourth comment", 2, "2009-07-06 11:01:20");
    news.addComment(comment1);
    news.addComment(comment2);
    news.addComment(comment3);
    news.addComment(comment4);

    tx.begin();
    em.persist(comment1);
    em.persist(comment2);
    em.persist(comment3);
    em.persist(comment4);
    em.persist(news);
    tx.commit();

    tx.begin();
    news = em.find(News.class, news.getId());

    // Without the refresh the test will not work
    // The OrderBy annotation specifies the ordering of the elements of a collection valued association at the point when the association is retrieved."
    // The key here is the phrase "when the association is retrieved".  In this case, when your find is executed, the association is still managed and no retrieval logic occurs.
    em.refresh(news);

    tx.commit();

    assertEquals("Death of Michael Jackson", news.getContent());
    assertEquals(4, news.getComments().size());
    assertEquals("Fourth comment", news.getComments().get(0).getContent());
    assertEquals("Third comment", news.getComments().get(1).getContent());
    assertEquals("Second comment", news.getComments().get(2).getContent());
    assertEquals("First comment", news.getComments().get(3).getContent());
  }
}
