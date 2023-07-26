package com.spring.petreact.data.respositories;

import com.spring.petreact.data.entites.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity,Long> {
}
