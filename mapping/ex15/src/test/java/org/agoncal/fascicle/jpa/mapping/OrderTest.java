package org.agoncal.fascicle.jpa.mapping;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  @Disabled // TODO
  public void shouldCreateAnOrderWithTwoOrderLines() throws Exception {

    Order order = new Order();
    OrderLine ol1 = new OrderLine("H2G2", 12d, 1);
    OrderLine ol2 = new OrderLine("The White Album", 14.5d, 2);
    List<OrderLine> orderLines = new ArrayList<>();
    orderLines.add(ol1);
    orderLines.add(ol2);
    order.setOrderLines(orderLines);
    tx.begin();
    em.persist(order);
    em.persist(ol1);
    em.persist(ol2);
    tx.commit();
    assertNotNull(order.getId(), "Order ID should not be null");
    assertNotNull(ol1.getId(), "OL1 ID should not be null");
    assertNotNull(ol2.getId(), "OL1 ID should not be null");

    order = em.find(Order.class, order.getId());
    assertNotNull(order.getOrderLines(), "OrderLines should not be null");
    assertEquals(2, order.getOrderLines().size(), "Should have 2 order lines");
  }
}
