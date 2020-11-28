package com.springfest.dddsample.order;

import lombok.Value;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author KIYOTA, Takeshi
 */
@Value
public class OrderCreated implements DomainEvent {

    // どの注文が登録されたかの情報を持つ
    private final Order order;
}
