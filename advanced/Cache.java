package org.agoncal.fascicle.jpa.managing;

// tag::adocSnippet[]
public interface Cache {

  // Whether the cache contains data for the given entity.
  public boolean contains(Class cls, Object primaryKey);

  // Remove the data for the given entity from the cache.
  public void evict(Class cls, Object primaryKey);

  // Remove the data for entities of the specified class (and its
  public void evict(Class cls);

  // Clear the cache.
  public void evictAll();

  // Returns the provider-specific cache implementation
  public <T> T unwrap(Class<T> cls);
}
// end::adocSnippet[]
