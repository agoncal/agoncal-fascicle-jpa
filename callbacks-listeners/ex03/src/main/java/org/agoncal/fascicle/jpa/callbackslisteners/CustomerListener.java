package org.agoncal.fascicle.jpa.callbackslisteners;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerListener {

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PrePersist
  void prePersist(Customer customer) {
    System.out.println(". prePersist");
  }

  @PreUpdate
  void preUpdate(Customer customer) {
    System.out.println(". preUpdate");
  }

  @PreRemove
  void preRemove(Customer customer) {
    System.out.println(". preRemove");
  }

  @PostLoad
  void postLoad(Customer customer) {
    System.out.println(". postLoad");
  }

  @PostRemove
  void postRemove(Customer customer) {
    System.out.println(". postRemove");
  }

  @PostUpdate
  void postUpdate(Customer customer) {
    System.out.println(". postUpdate");
  }

  @PostPersist
  void postPersist(Customer customer) {
    System.out.println(". postPersist");
  }
}
