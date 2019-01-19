package org.agoncal.fascicle.jpa.managing.ex05;

import static javax.persistence.CascadeType.PERSIST;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// TODO get rid of @NamedQueries repeatable annotation
// tag::adocSnippet[]
@Entity
@NamedQueries({
  @NamedQuery(name = "findAll", query = "select c from Customer c"),
  @NamedQuery(name = "findVincent", query = "select c from Customer c where c.firstName = 'Vincent'"),
  @NamedQuery(name = "findWithParam", query = "select c from Customer c where c.firstName = :fname")
})
public class Customer {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
  @OneToOne(cascade = {PERSIST})
  private Address address;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
