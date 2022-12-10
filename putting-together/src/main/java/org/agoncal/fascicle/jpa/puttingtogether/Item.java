package org.agoncal.fascicle.jpa.puttingtogether;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@MappedSuperclass
public class Item {

  @Id
  @GeneratedValue
  protected Long id;
  protected String title;
  protected String description;
  protected Float price;

  // Getters, setters
}
// end::adocSnippet[]
