package com.springfest.dddsample.inventory;

import lombok.Value;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author KIYOTA, Takeshi
 */
@Value
public class InventoryCreated implements DomainEvent {

    private final Inventory inventory;
}
