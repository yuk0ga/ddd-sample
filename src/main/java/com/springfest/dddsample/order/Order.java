package com.springfest.dddsample.order;

import com.springfest.dddsample.core.SurrogateId;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KOGA, Yu
 */
@Getter
public class Order implements AggregateRoot<Order, SurrogateId> {

    private final SurrogateId id = SurrogateId.create();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn
    @Column(unique = true)
    private final List<OrderLine> lines = new ArrayList<>();

}
