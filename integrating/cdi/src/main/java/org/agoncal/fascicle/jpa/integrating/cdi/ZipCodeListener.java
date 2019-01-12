package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class ZipCodeListener {

  @Inject
  private ZipCodeChecker checker;

}
// end::adocSnippet[]
