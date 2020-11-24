package com.springfest.dddsample.inventory;

import org.jmolecules.event.types.DomainEvent;

/**
 * @author KIYOTA, Takeshi
 */
public class InventoryDecreased implements DomainEvent {

    private final Inventory inventory;
}
