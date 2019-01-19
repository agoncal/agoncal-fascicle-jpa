package org.agoncal.fascicle.jpa.managing.ex07;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// TODO get rid of @NamedQueries repeatable annotation
@Entity
@Table(name = "t_customer")
@NamedNativeQueries({
  @NamedNativeQuery(name = "findAllNative", query = "select * from JPQL_EX01_CUSTOMER", resultClass = Customer.class)
})
public class Customer {

  public static final String FIND_ALL = "Customer.findAll";

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private Integer age;
  private String email;
  @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "address_fk")
  private Address address;

  // ======================================
  // =            Constructors            =
  // ======================================

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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
