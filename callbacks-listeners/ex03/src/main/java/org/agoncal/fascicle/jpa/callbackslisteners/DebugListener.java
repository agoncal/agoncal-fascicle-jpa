package org.agoncal.fascicle.jpa.callbackslisteners;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class DebugListener {

  @PrePersist
  void prePersist(Object object) {
    System.out.println("prePersist");
  }

  @PreUpdate
  void preUpdate(Object object) {
    System.out.println("preUpdate");
  }

  @PreRemove
  void preRemove(Object object) {
    System.out.println("preRemove");
  }
  // tag::adocSkip[]

  @PostPersist
  void postPersist(Object object) {
    System.out.println("postPersist");
  }

  @PostUpdate
  void postUpdate(Object object) {
    System.out.println("postUpdate");
  }

  @PostRemove
  void postRemove(Object object) {
    System.out.println("postRemove");
  }

  @PostLoad
  void postLoad(Object object) {
    System.out.println("postLoad");
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
