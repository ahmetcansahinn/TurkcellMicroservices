package com.turkcell.product.service.repositories;

import com.turkcell.product.service.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByInventoryCode(String inventoryCode);

    @Query("{'inventoryCode': ?0 }")
    Product findByInventoryCodeQuery(String invCode);
}
