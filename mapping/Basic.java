package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.FetchType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static javax.persistence.FetchType.EAGER;

// @formatter:off
// tag::adocSnippet[]
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Basic {

  FetchType fetch() default EAGER;
  boolean optional() default true;
}
// end::adocSnippet[]
