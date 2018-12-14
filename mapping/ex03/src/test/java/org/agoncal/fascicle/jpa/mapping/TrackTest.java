package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class TrackTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateATrack() throws Exception {

    Track track = new Track("Sgt Pepper Lonely Heart Club Ban", 4.53f, "Listen to the trumpet carefully, it's George Harrison playing");
    tx.begin();
    em.persist(track);
    tx.commit();
    assertNotNull(track.getId(), "ID should not be null");
  }
}
