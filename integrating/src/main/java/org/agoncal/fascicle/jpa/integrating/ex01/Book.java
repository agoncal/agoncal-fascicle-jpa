package org.agoncal.fascicle.jpa.integrating.ex01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Entity
public class Book {

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private String title;
  private Float price;
  @Size(min = 10, max = 2000)
  private String description;
  private String isbn;
  private Integer nbOfPages;
  private Boolean illustrations;
// Constructors, getters, setters
}
// end::adocsnippet[]
