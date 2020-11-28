package com.springfest.dddsample.order;

import com.springfest.dddsample.core.SurrogateId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jmolecules.ddd.types.Entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;

/**
 * @author KIYOTA, Takeshi
 * 注文明細
 * Order にぶら下がる entity
 */
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class OrderLine implements Entity<Order, SurrogateId> {

    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private final SurrogateId id = SurrogateId.create();

    private final String name;
    private final int quantity;
    private final int price;
}
