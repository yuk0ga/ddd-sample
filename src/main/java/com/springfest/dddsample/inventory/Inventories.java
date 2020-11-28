package com.springfest.dddsample.inventory;

import com.springfest.dddsample.core.SurrogateId;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KIYOTA, Takeshi
 */
@DomainRing  // Domain Service (同じ集約ルート内に属する、複数の集約の状態を見る必要がある時に使用)
public interface Inventories extends JpaRepository<Inventory, SurrogateId> {
}
