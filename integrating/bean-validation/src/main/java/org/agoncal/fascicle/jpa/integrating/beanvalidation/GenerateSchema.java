package org.agoncal.fascicle.jpa.integrating.beanvalidation;

import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class GenerateSchema {

  public static void main(String[] args) {

    Persistence.generateSchema("beanvalidationPU", null);
    System.exit(0);
  }
}
