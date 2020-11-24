package com.springfest.dddsample.order;

import org.jmolecules.architecture.onion.simplified.ApplicationRing;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing
public interface OrderService {

    Order createOrder(CreateOrder command);
}
