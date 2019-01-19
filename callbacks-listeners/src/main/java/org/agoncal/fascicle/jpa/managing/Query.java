package org.agoncal.fascicle.jpa.managing;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

// @formatter:off
// tag::adocSnippet[]
public interface Query {

  // Executes a query and returns a result
  List getResultList();
  default Stream getResultStream() {
    return getResultList().stream();
  }
  Object getSingleResult();
  int executeUpdate();


  // Sets parameters to the query
  <T> Query setParameter(Parameter<T> param, T value);
  Query setParameter(Parameter<Calendar> param, Calendar value,
                     TemporalType temporalType);
  Query setParameter(Parameter<Date> param, Date value,
                     TemporalType temporalType);
  Query setParameter(String name, Object value);
  Query setParameter(String name, Calendar value,
                     TemporalType temporalType);
  Query setParameter(String name, Date value,
                     TemporalType temporalType);
  Query setParameter(int position, Object value);
  Query setParameter(int position, Calendar value,
                     TemporalType temporalType);
  Query setParameter(int position, Date value,
                     TemporalType temporalType);


  // Gets parameters from the query
  Set<Parameter<?>> getParameters();
  Parameter<?> getParameter(String name);
  <T> Parameter<T> getParameter(String name, Class<T> type);
  Parameter<?> getParameter(int position);
  <T> Parameter<T> getParameter(int position, Class<T> type);
  boolean isBound(Parameter<?> param);
  <T> T getParameterValue(Parameter<T> param);
  Object getParameterValue(String name);
  Object getParameterValue(int position);


  // Constrains the number of results returned by a query
  Query setMaxResults(int maxResult);
  int getMaxResults();
  Query setFirstResult(int startPosition);
  int getFirstResult();


  // Sets and gets query hints
  Query setHint(String hintName, Object value);
  Map<String, Object> getHints();


  // Sets the flush mode type to be used for the query execution
  Query setFlushMode(FlushModeType flushMode);
  FlushModeType getFlushMode();


  // Sets the lock mode type to be used for the query execution
  Query setLockMode(LockModeType lockMode);
  LockModeType getLockMode();


  // Allows access to the provider-specific API
  <T> T unwrap(Class<T> cls);
}
// end::adocSnippet[]
