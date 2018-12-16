package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class PurchaseOrderTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateAnOrderWithTwoOrderLines() throws Exception {

    OrderLine ol1 = new OrderLine("H2G2", 12d, 1);
    OrderLine ol2 = new OrderLine("The White Album", 14.5d, 2);
    PurchaseOrder order = new PurchaseOrder();
    order.setOrderLines(Arrays.asList(ol1, ol2));
    tx.begin();
    em.persist(order);
    em.persist(ol1);
    em.persist(ol2);
    tx.commit();
    assertNotNull(order.getId(), "Order ID should not be null");
    assertNotNull(ol1.getId(), "OL1 ID should not be null");
    assertNotNull(ol2.getId(), "OL1 ID should not be null");

    order = em.find(PurchaseOrder.class, order.getId());
    assertNotNull(order.getOrderLines(), "OrderLines should not be null");
    assertEquals(2, order.getOrderLines().size(), "Should have 2 order lines");
  }
}
