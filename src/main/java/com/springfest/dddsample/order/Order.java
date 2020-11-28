package com.springfest.dddsample.order;

import com.springfest.dddsample.core.SurrogateId;
import com.springfest.dddsample.inventory.Inventory;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 注文
 * @author KOGA, Yu
 */
@Getter
@Entity
public class Order extends AbstractAggregateRoot implements AggregateRoot<Order, SurrogateId> {

    @EmbeddedId // 複合主キーに対して使用
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private final SurrogateId id = SurrogateId.create();

    private final OrderNumber orderNo;

    private LocalDate orderDate;

    private Long amount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 受注に紐づく明細が更新された時、以前の明細は削除する
    @OrderColumn
    @Column(unique = true) // 受注の中の明細は一意であるから(同じ項目であれば束ねられる)
    private final List<OrderLine> lines = new ArrayList<>();

    private final Inventory.InventoryAssociation inventory;

    public Order(OrderNumber orderNo, Inventory.InventoryAssociation inventory, OrderLine... lines) {
        this.orderNo = orderNo;
        this.inventory = inventory;
        this.lines.addAll(Arrays.asList(lines));
    }

    @PrePersist // 自身の集約が永続化される時をフックして実行されるメソッド
    void persist(){
        // domain event を登録
        registerEvent(new OrderCreated(this));
    }
}
