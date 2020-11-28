package com.springfest.dddsample.order;

import org.jmolecules.architecture.onion.simplified.ApplicationRing;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing // Application Service (集約ルートをまたぐロジックを呼び出す必要がある場合に使用)
public interface OrderService {

    Order createOrder(CreateOrder command);
}
