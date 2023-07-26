package com.spring.petreact.data.respositories;

import com.spring.petreact.data.entites.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
