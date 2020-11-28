package com.springfest.dddsample.order.internal;


import com.springfest.dddsample.inventory.CheckInventoryException;
import com.springfest.dddsample.inventory.Inventories;
import com.springfest.dddsample.inventory.Inventory;
import com.springfest.dddsample.order.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing // Application Service (集約ルートをまたぐロジックを呼び出す必要がある場合に使用)
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Inventories inventories;
    private final OrderNumberGenerator orderNumberGenerator;
    private OrderLine OrderLine;
    private Orders orders;

    @Override
    public Order createOrder(CreateOrder command) {
        log.info("在庫チェック");
        var inventory = this.inventories.findById(command.getFrom()).orElseThrow();

        // 在庫チェックがどういうロジックで行われるかは Application Service はタッチしない(domain layer のみが知る)
        if (!inventory.checkInventories()){
            throw new CheckInventoryException();
        }

        log.info("注文番号の採番");
        var orderNo = this.orderNumberGenerator.generate();

        log.info("注文登録");
        // 注文集約を生成して
        var order = new Order(orderNo, new Inventory.InventoryAssociation(inventory), OrderLine);
        return this.orders.save(order);
    }

    // TODO: Read Model の更新
}
