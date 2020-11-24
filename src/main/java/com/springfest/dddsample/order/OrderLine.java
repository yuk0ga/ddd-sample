package com.springfest.dddsample.order;

import com.springfest.dddsample.core.SurrogateId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jmolecules.ddd.types.Entity;

/**
 * @author KIYOTA, Takeshi
 */
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class OrderLine implements Entity<Order, SurrogateId> {

    private final SurrogateId id = SurrogateId.create();

    private final String name;
    private final int quantity;
    private final int price;
}
