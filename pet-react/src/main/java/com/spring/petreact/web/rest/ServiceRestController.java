package com.spring.petreact.web.rest;

import com.spring.petreact.services.ServiceService;
import com.spring.petreact.web.errors.BadRequestException;
import com.spring.petreact.web.models.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceRestController{
    private final ServiceService serviceService;

    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getServices (){
        return this.serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public Service getService(@PathVariable("id") long id){
        return this.serviceService.getService(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service addService(@RequestBody Service service){
        return this.serviceService.createOrUpdateService(service);
    }

    @PutMapping("/{id}")
    public Service updateService(@PathVariable("id") Long id, @RequestBody Service service){
        if (id != service.getServiceId()){
            throw new BadRequestException("incoming id doesn't match path");
        }
        return this.serviceService.createOrUpdateService(service);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteService(@PathVariable("id") long id){
        this.serviceService.deleteService(id);
    }
}
