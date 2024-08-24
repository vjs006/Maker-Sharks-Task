package com.api.controller;

import java.util.List;
import com.api.models.Manufacturer;
import com.api.models.Supplier;

public class PaginationResponse {
    private Supplier supplier;
    private List<Manufacturer> manufacturers;
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
    
    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    // Getters and setters
    
}
