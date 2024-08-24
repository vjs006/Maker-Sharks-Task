package com.api.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Manufacturer;

public interface SupplierRepository extends JpaRepository<Manufacturer, Long> {
    Page<Manufacturer> findAll(String supplier_id, Pageable pageable);
}
