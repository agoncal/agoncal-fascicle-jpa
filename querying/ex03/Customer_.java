import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

// tag::adocSnippet[]
@StaticMetamodel(Customer.class)
public class Customer_ {

  public static volatile SingularAttribute<Customer, Long> id;
  public static volatile SingularAttribute<Customer, String> firstName;
  public static volatile SingularAttribute<Customer, String> lastName;
  public static volatile SingularAttribute<Customer, String> email;
  public static volatile SingularAttribute<Customer, Integer> age;
  public static volatile SingularAttribute<Customer, Address> address;

  // tag::adocSkip[]
  public Customer_() {
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
