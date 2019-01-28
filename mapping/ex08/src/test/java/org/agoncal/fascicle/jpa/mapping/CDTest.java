package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
  public void shouldCreateACDWithAMapOfTracks() throws Exception {

    HashMap<Integer, String> tracks = new HashMap<>();
    tracks.put(1, "Wind Up Workin' in a Gas Station");
    tracks.put(2, "Black Napkins");
    tracks.put(3, "The Torture Never Stops");
    CD cd = new CD("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album", tracks);
    tx.begin();
    em.persist(cd);
    tx.commit();
    assertNotNull(cd.getId(), "Id should not be null");
    assertEquals(3, cd.getTracks().size());
  }
}
