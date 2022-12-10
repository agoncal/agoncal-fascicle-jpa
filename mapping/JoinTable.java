package org.agoncal.fascicle.jpa.mapping;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static jakarta.persistence.ConstraintMode.PROVIDER_DEFAULT;

// @formatter:off
// tag::adocSnippet[]
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface JoinTable {

  String name() default "";
  String catalog() default "";
  String schema() default "";
  JoinColumn[] joinColumns() default {};
  JoinColumn[] inverseJoinColumns() default {};
  ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
  ForeignKey inverseForeignKey() default @ForeignKey(PROVIDER_DEFAULT);
  UniqueConstraint[] uniqueConstraints() default {};
  Index[] indexes() default {};
}
// end::adocSnippet[]
