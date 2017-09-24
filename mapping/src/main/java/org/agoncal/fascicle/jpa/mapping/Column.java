package org.agoncal.fascicle.jpa.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// @formatter:off
// tag::adocSnippet[]
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Column {

  String  name()       default "";
  boolean unique()     default false;
  boolean nullable()   default true;
  boolean insertable() default true;
  boolean updatable()  default true;
  String  columnDefinition() default "";
  String  table()      default "";
  int     length()     default 255;
  int     precision()  default 0; // decimal precision
  int     scale()      default 0; // decimal precision
}
// end::adocSnippet[]
