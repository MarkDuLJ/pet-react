package com.spring.petreact.services;

import com.spring.petreact.data.entites.CustomerEntity;
import com.spring.petreact.data.respositories.CustomerRepository;
import com.spring.petreact.web.errors.NotFoundException;
import com.spring.petreact.web.models.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(String filter){
        List<Customer> customers = new ArrayList<>();
        if(StringUtils.hasLength(filter)){
            CustomerEntity entity = this.customerRepository.findByEmail(filter);
            customers.add(this.translateDbToWeb(entity));
        }else {
            Iterable<CustomerEntity> entities = this.customerRepository.findAll();
            entities.forEach(entity->{
                customers.add(this.translateDbToWeb(entity));
            });
        }

        return customers;
    }

    public Customer getCustomer(long id){
        Optional<CustomerEntity> optionalCustomer = this.customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new NotFoundException("customer not found with id: "+id);
        }

        return this.translateDbToWeb(optionalCustomer.get());
    }

    public  Customer createOrUpdate(Customer customer){
        CustomerEntity entity = this.translateWebToDb(customer);
        entity = this.customerRepository.save(entity);

        return this.translateDbToWeb(entity);
    }

    public void deleteCustomer(long id){
        this.customerRepository.deleteById(id);
    }

    private CustomerEntity translateWebToDb(Customer customer){
        CustomerEntity entity= new CustomerEntity();
        entity.setId(customer.getCustomerId());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());

        return entity;
    }

    private  Customer translateDbToWeb(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setEmail(customerEntity.getEmail());
        customer.setPhone(customerEntity.getPhone());
        customer.setAddress(customerEntity.getAddress());

        return customer;
    }
}
