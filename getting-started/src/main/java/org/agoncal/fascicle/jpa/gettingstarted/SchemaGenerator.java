package org.agoncal.fascicle.jpa.gettingstarted;

import jakarta.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class SchemaGenerator {

  public static void main(String[] args) {

    Persistence.generateSchema("cdbookstorePU", null);
  }
}
// end::adocSnippet[]
