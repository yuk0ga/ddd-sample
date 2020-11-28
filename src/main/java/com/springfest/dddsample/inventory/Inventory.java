package com.springfest.dddsample.inventory;

import com.springfest.dddsample.core.SurrogateId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;

import javax.persistence.*;

/**
 * 在庫
 *
 * @author KIYOTA, Takeshi
 */
@Getter
@Entity
public class Inventory implements AggregateRoot<Inventory, SurrogateId> {

    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private final SurrogateId id = SurrogateId.create();

    private String name;

    // 在庫数
    private Long amount;

    public boolean checkInventories() {
        // 自身の在庫数を確認(policy の付箋で表現されているもの)
        return this.amount > 1;
    }

    // 在庫を減らす
    public Inventory decreaseReceivable(Long orderedAmount){
        this.amount -= orderedAmount;
        return this;
    }

    @Embeddable
    @Getter
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    public static class InventoryAssociation implements Association<Inventory, SurrogateId> {

        @AttributeOverride(name = "id", column = @Column(name = "inventory_id"))
        private SurrogateId id;

        public InventoryAssociation(Inventory inventory) {
            this.id = inventory.getId();
        }
    }
}
