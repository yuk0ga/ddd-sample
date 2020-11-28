package com.springfest.dddsample.inventory.internal;

import com.springfest.dddsample.inventory.*;
import com.springfest.dddsample.order.OrderCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final Inventories inventories;
    private final InventoryProjections inventoryProjections;

    @EventListener // 引数で指定した型の event を購読
    @Override
    public void updateReceivable(OrderCreated event) {
        log.info("注文が登録されたので、在庫数を減らす");
        // 受け取ったイベントの対象の在庫IDから在庫集約を取得
        var inventory = this.inventories.findById(event.getOrder().getInventory().getId()).orElseThrow();
        this.inventories.save(inventory.decreaseReceivable(event.getOrder().getAmount()));
    }
}
