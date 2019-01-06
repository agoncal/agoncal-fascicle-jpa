import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

// tag::adocSnippet[]
@StaticMetamodel(Customer.class)
public class Customer_ {

  public static volatile SingularAttribute<Customer, String> firstName;
  public static volatile SingularAttribute<Customer, String> lastName;
  public static volatile SingularAttribute<Customer, Address> address;
  public static volatile SingularAttribute<Customer, Long> id;
  public static volatile SingularAttribute<Customer, String> email;
  public static volatile SingularAttribute<Customer, Integer> age;

  // tag::adocSkip[]
  public Customer_() {
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
