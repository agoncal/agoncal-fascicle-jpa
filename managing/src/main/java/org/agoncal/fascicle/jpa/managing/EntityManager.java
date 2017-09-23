package org.agoncal.fascicle.jpa.managing;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

// @formatter:off
// tag::adocsnippet[]
public interface EntityManager {

  // Factory to create an entity manager, close it and check if it's open
  public void close();
  public boolean isOpen();
  public EntityManagerFactory getEntityManagerFactory();


  // Returns an entity transaction
  public EntityTransaction getTransaction();


  // Indicates that a JTA transaction is active and joins the persistence context to it
  public void joinTransaction();
  public boolean isJoinedToTransaction();


  // Persists, merges and removes and entity to/from the database
  public void persist(Object entity);
  public <T> T merge(T entity);
  public void remove(Object entity);

  // Finds an entity based on its primary key (with different lock mecanisms)
  public <T> T find(Class<T> entityClass, Object primaryKey);
  public <T> T find(Class<T> entityClass, Object primaryKey,
                    Map<String, Object> properties);
  public <T> T find(Class<T> entityClass, Object primaryKey,
                    LockModeType lockMode);
  public <T> T find(Class<T> entityClass, Object primaryKey,
                    LockModeType lockMode,
                    Map<String, Object> properties);
  public <T> T getReference(Class<T> entityClass,
                            Object primaryKey);


  // Locks an entity with the specified lock mode type (optimistic, pessimistic...)
  public void lock(Object entity, LockModeType lockMode);
  public void lock(Object entity, LockModeType lockMode,
                   Map<String, Object> properties);
  public LockModeType getLockMode(Object entity);


  // Synchronizes the persistence context to the underlying database
  public void flush();
  public void setFlushMode(FlushModeType flushMode);
  public FlushModeType getFlushMode();


  // Refreshes the state of the entity from the database, overwriting any changes made
  public void refresh(Object entity);
  public void refresh(Object entity,
                      Map<String, Object> properties);
  public void refresh(Object entity, LockModeType lockMode);
  public void refresh(Object entity, LockModeType lockMode,
                      Map<String, Object> properties);


  // Clears the persistence context and checks if it contains an entity
  public void clear();
  public void detach(Object entity);
  public boolean contains(Object entity);


  // Sets and gets an entity manager property or hint
  public void setProperty(String propertyName, Object value);
  public Map<String, Object> getProperties();


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


  // Return the underlying provider object for the EntityManager
  public <T> T unwrap(Class<T> cls);
  public Object getDelegate();


  // Returns an entity graph
  public <T> EntityGraph<T> createEntityGraph(Class<T> rootType);
  public EntityGraph<?> createEntityGraph(String graphName);
  public  EntityGraph<?> getEntityGraph(String graphName);
  public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass);
}
// end::adocsnippet[]
