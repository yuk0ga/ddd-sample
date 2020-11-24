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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 受注に紐づく明細が更新された時、以前の明細は削除する
    @OrderColumn
    @Column(unique = true) // 受注の中の明細は一意であるから(同じ項目であれば束ねられる)
    private final List<OrderLine> lines = new ArrayList<>();

}
