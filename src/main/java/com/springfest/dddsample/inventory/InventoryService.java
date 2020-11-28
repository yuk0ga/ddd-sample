package com.springfest.dddsample.inventory;

import com.springfest.dddsample.order.OrderCreated;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing
public interface InventoryService {

    void updateReceivable(OrderCreated event);
}
