import java.util.List;
import java.util.stream.Stream;

// @formatter:off
// tag::adocSnippet[]
public interface TypedQuery<X> extends Query {

  default Stream<X> getResultStream() {
    return getResultList().stream();
  }
  List<X> getResultList();
  X getSingleResult();

  // ...
}
// end::adocSnippet[]
