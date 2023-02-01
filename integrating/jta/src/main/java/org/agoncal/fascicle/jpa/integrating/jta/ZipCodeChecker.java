package org.agoncal.fascicle.jpa.integrating.jta;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.regex.Pattern;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class ZipCodeChecker {

  private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

  public boolean isValid(String zipcode) {
    if (zipcode == null)
      return true;

    return zipPattern.matcher(zipcode).matches();
  }

}
// end::adocSnippet[]
