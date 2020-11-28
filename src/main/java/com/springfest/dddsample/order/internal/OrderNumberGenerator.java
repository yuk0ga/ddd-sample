package com.springfest.dddsample.order.internal;

import com.springfest.dddsample.order.OrderNumber;
import com.springfest.dddsample.order.Orders;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.stereotype.Component;

/**
 * @author KIYOTA, Takeshi
 */
@DomainRing // Domain Service (同じ集約ルート内に属する、複数の集約の状態を見る必要がある時に使用)
@Component
@RequiredArgsConstructor
public class OrderNumberGenerator {

    private final Orders orders;

    // TODO: 現在日付や登録されているものの最新の番号をインクリメントしたものなどのロジックを実装
    public OrderNumber generate(){
        return OrderNumber.of("ABC-12345");
    }
}
