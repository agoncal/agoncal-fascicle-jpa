package org.agoncal.fascicle.jpa.integrating.jta;

import com.arjuna.ats.jta.common.jtaPropertyManager;
import jakarta.transaction.Synchronization;
import jakarta.transaction.UserTransaction;
import org.jboss.weld.transaction.spi.TransactionServices;

public class TestingTransactionServices implements TransactionServices {

  @Override
  public void cleanup() {
  }

  @Override
  public void registerSynchronization(Synchronization synchronizedObserver) {
    jtaPropertyManager.getJTAEnvironmentBean()
      .getTransactionSynchronizationRegistry();
//      .registerInterposedSynchronization(synchronizedObserver);
  }

  @Override
  public boolean isTransactionActive() {
//    try {
      return false; // TODO com.arjuna.ats.jta.UserTransaction.userTransaction().getStatus() == Status.STATUS_ACTIVE;
//    } catch (SystemException e) {
//      throw new RuntimeException(e);
//    }
  }

  @Override
  public UserTransaction getUserTransaction() {
    return null;// TODO com.arjuna.ats.jta.UserTransaction.userTransaction();
  }
}
