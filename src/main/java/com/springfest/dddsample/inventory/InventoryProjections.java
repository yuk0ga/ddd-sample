package com.springfest.dddsample.inventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
public interface InventoryProjections extends ElasticsearchRepository<InventoryProjection, UUID> {

    Page<InventoryProjection> findByName(String name, Pageable pageable);
}
