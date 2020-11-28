package com.springfest.dddsample.order;

import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@DomainRing // Domain Service (同じ集約ルート内に属する、複数の集約の状態を見る必要がある時に使用)
public interface Orders extends JpaRepository<Order, UUID> {
}
