package com.spring.petreact.web.rest;

import com.spring.petreact.services.VendorService;
import com.spring.petreact.web.errors.BadRequestException;
import com.spring.petreact.web.models.Vendor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorRestController {
    private final VendorService vendorService;

    public VendorRestController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getVendors(){
        return this.vendorService.getVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable("id") long id){
        return this.vendorService.getVendor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor vendor){
        return this.vendorService.createOrUpdateVendor(vendor);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable("id") long id, @RequestBody Vendor vendor){
        if(id!=vendor.getVendorId()){
            throw new BadRequestException("ids don't match");
        }

        return this.vendorService.createOrUpdateVendor(vendor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteVendor(@PathVariable("id") long id){
        this.vendorService.deleteVendor(id);
    }
}
