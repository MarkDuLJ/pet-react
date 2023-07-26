package com.spring.petreact.data.respositories;

import com.spring.petreact.data.entites.VendorEntity;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<VendorEntity, Long> {
}
