package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static jakarta.persistence.FetchType.EAGER;

// @formatter:off
// tag::adocSnippet[]
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface OneToOne {

  Class targetEntity() default void.class;
  CascadeType[] cascade() default {};
  FetchType fetch() default EAGER;
  boolean optional() default true;
  String mappedBy() default "";
  boolean orphanRemoval() default false;
}
// end::adocSnippet[]
