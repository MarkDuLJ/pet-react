package com.spring.petreact.data.respositories;

import com.spring.petreact.data.entites.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
}
