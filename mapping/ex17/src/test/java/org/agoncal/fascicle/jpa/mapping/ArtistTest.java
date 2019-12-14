package org.agoncal.fascicle.jpa.mapping;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ArtistTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateThreeCDsAndFourArtists() throws Exception {

    Artist ringo = new Artist("Ringo", "Starr");
    Artist john = new Artist("John", "Lennon");
    Artist franck = new Artist("Franck", "Zappa");
    Artist jimi = new Artist("Jimi", "Hendrix");

    CD zoot = new CD("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
    CD sgtpepper = new CD("Sergent Pepper", 28.5F, "Best Beatles Album");
    CD heyjoe = new CD("Hey Joe", 32F, "Hendrix live with friends");

    ringo.appearsOn(sgtpepper);
    john.appearsOn(sgtpepper);
    john.appearsOn(heyjoe);
    franck.appearsOn(zoot);
    franck.appearsOn(heyjoe);
    jimi.appearsOn(heyjoe);
    jimi.appearsOn(sgtpepper);

    zoot.createdBy(franck);
    sgtpepper.createdBy(ringo);
    sgtpepper.createdBy(john);
    heyjoe.createdBy(jimi);

    tx.begin();
    em.persist(ringo);
    em.persist(john);
    em.persist(franck);
    em.persist(jimi);
    em.persist(zoot);
    em.persist(sgtpepper);
    em.persist(heyjoe);
    tx.commit();
    assertNotNull(ringo.getId(), "Ringo Id should not be null");
    assertNotNull(john.getId(), "John Id should not be null");
    assertNotNull(franck.getId(), "Franck Id should not be null");
    assertNotNull(zoot.getId(), "Zoot Id should not be null");
    assertNotNull(sgtpepper.getId(), "Sgt Pepper Id should not be null");
    assertNotNull(heyjoe.getId(), "Hey Joe Id should not be null");
  }
}
