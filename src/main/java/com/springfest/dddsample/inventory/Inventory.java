package com.springfest.dddsample.inventory;

import com.springfest.dddsample.core.SurrogateId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;

import javax.persistence.*;

/**
 * @author KIYOTA, Takeshi
 */
@Getter
@Entity
public class Inventory implements AggregateRoot<Inventory, SurrogateId> {

    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private SurrogateId id;

    private String name;

    @Embeddable
    @Getter
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    public static class InventoryAssociation implements Association<Inventory, SurrogateId>{

        @AttributeOverride(name = "id", column = @Column(name = "product_id"))
        private SurrogateId id;

        public InventoryAssociation(Inventory inventory) {
            this.id = inventory.getId();
    }

    public Inventory decreaseInventory(){
        registerEvent(new InventoryDecreased(this));
    }

    }
}
