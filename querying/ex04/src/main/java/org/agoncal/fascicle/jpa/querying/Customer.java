package org.agoncal.fascicle.jpa.querying;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import static jakarta.persistence.CascadeType.PERSIST;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
@Entity
@Table(name = "t_customer")
@NamedNativeQuery(name = "findAll", query = "SELECT * FROM t_customer", resultClass = Customer.class)
public class Customer {

  // ...
  // end::adocBegin[]

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

  public static final String FIND_ALL = "Customer.findAll";

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
  // end::adocEnd[]
}
// end::adocEnd[]
