package com.api.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Manufacturer;
import com.api.models.Supplier;
import com.api.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class SupplierController {
    private SupplierService supplierService = new SupplierService();

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/api/supplier/query")
    public ResponseEntity<?> getManufacteresForId(@RequestParam String supplierId) {
        try {
            System.out.println("Eureka");
            return new ResponseEntity<List<Manufacturer>>(supplierService.getManufacturers(supplierId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>("An error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/supplier/query")
    public Supplier getSupplier(@RequestParam String supplierId) {
        System.out.println("Request received for supplierId: " + supplierId);
        return supplierService.getSupplier(supplierId);
    }

}
