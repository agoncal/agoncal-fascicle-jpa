package org.agoncal.fascicle.jpa.understanding.ex01;

import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SchemaGenerator {

  public static void main(String[] args) {

    Persistence.generateSchema("jpaPU", null);
  }
}
