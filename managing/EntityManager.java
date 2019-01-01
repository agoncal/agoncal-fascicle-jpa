package javax.persistence;

import java.util.Map;
import java.util.List;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.CriteriaDelete;

// @formatter:off
// tag::adocEntityManager[]
public interface EntityManager {

  // Factory to create an entity manager, close it and check if it's open
  public void close();
  public boolean isOpen();
  public EntityManagerFactory getEntityManagerFactory();

  // Return the underlying provider object for the EntityManager
  public <T> T unwrap(Class<T> cls);
  public Object getDelegate();

  // Sets and gets an entity manager property or hint
  public void setProperty(String propertyName, Object value);
  public Map<String, Object> getProperties();

  // end::adocEntityManager[]
  // tag::adocTransaction[]
  // Returns an entity transaction
  public EntityTransaction getTransaction();

  // Indicates if a JTA transaction is active and joins the persistence context to it
  public void joinTransaction();
  public boolean isJoinedToTransaction();

  // Locks an entity with the specified lock mode type (optimistic, pessimistic...)
  public void lock(Object entity, LockModeType lockMode);
  public LockModeType getLockMode(Object entity);
  // end::adocTransaction[]
  // tag::adocCRUD[]
  // Persists, merges, removes and finds an entity to/from the database
  public void persist(Object entity);
  public <T> T merge(T entity);
  public void remove(Object entity);
  public <T> T find(Class<T> entityClass, Object primaryKey);
  public <T> T getReference(Class<T> entityClass, Object primaryKey);
  // end::adocCRUD[]
  // tag::adocPersistenceContext[]
  // Synchronizes the persistence context to the underlying database
  public void flush();
  public void setFlushMode(FlushModeType flushMode);
  public FlushModeType getFlushMode();

  // Refreshes the state of the entity from the database, overwriting any changes made
  public void refresh(Object entity);
  public void refresh(Object entity, LockModeType lockMode);

  // Clears the persistence context and checks if it contains an entity
  public void clear();
  public void detach(Object entity);
  public boolean contains(Object entity);
  // end::adocPersistenceContext[]
  // tag::adocQuery[]
  // Creates an instance of Query or TypedQuery for executing a JPQL statement
  public Query createQuery(String qlString);
  public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass);

  // Creates an instance of Query or TypedQuery for executing a named query
  public Query createNamedQuery(String name);
  public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass);

  // Creates an instance of Query for executing a native SQL query
  public Query createNativeQuery(String sqlString);
  public Query createNativeQuery(String sqlString, Class resultClass);
  public Query createNativeQuery(String sqlString, String resultSetMapping);

  // Creates a StoredProcedureQuery for executing a stored procedure in the database
  public StoredProcedureQuery createNamedStoredProcedureQuery(String name);
  public StoredProcedureQuery createStoredProcedureQuery(String procedureName);
  public StoredProcedureQuery createStoredProcedureQuery(
    String procedureName, Class... resultClasses);
  public StoredProcedureQuery createStoredProcedureQuery(
    String procedureName, String... resultSetMappings);

  // Metamodel and criteria builder for criteria queries (select, update and delete)
  public CriteriaBuilder getCriteriaBuilder();
  public Metamodel getMetamodel();
  public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery);
  public Query createQuery(CriteriaUpdate updateQuery);
  public Query createQuery(CriteriaDelete deleteQuery);

  // Creates and returns an entity graph
  public <T> EntityGraph<T> createEntityGraph(Class<T> rootType);
  public EntityGraph<?> createEntityGraph(String graphName);
  public  EntityGraph<?> getEntityGraph(String graphName);
  public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass);
}
// end::adocQuery[]
