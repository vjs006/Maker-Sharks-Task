package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.models.Manufacturer;
import com.api.models.Supplier;

@Service
public class SupplierService {
    CSVFileOperations file1 = new CSVFileOperations("src\\main\\resources\\static\\Suppliers.csv");
    CSVFileOperations file2 = new CSVFileOperations("src\\main\\resources\\static\\Manufacturers.csv");

    private List<Supplier> supplierList = new ArrayList<Supplier>();
    private List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
    private int totalManufacturersForSupId = 0;

    public SupplierService(){
        for (List<String> record: file1.getRecords()){
            supplierList.add(new Supplier(record));
        }
        for (List<String> record: file2.getRecords()){
            manufacturerList.add(new Manufacturer(record));
        }
    }

    public List<Manufacturer> getManufacturers(String supplierId, String srchLocation, String srchNature, String srchProcess, int page, int size) {
        List<Manufacturer> filteredManufacturers = new ArrayList<Manufacturer>();
        totalManufacturersForSupId = 0;
        Supplier supplier = this.getSupplier(supplierId, srchLocation, srchNature, srchProcess);

        if (supplier != null){
            for (Manufacturer manufacturer: manufacturerList){
                if (manufacturer.getLocation().equals(srchLocation) 
                    && manufacturer.getNatureOfBusiness().equals(srchNature)
                    && manufacturer.getManufacturingProcess().equals(srchProcess)){
                    this.totalManufacturersForSupId++;
                    filteredManufacturers.add(manufacturer);
                }
            }
        }
        int start = page * size;
        int end = Math.min(start + size, filteredManufacturers.size());
        if (page >= (int) Math.ceil((double) this.totalManufacturersForSupId / size))
            return new ArrayList<>();
        // Return a sublist for pagination
        return filteredManufacturers.subList(start, end);
    }

    public Supplier getSupplier(String supplierId, String srchLocation, String srchNature, String srchProcess) {
        for (Supplier supplier: supplierList){
            if (supplier.getSupplier_id().equals(supplierId)
                && supplier.getLocation().equals(srchLocation)
                && supplier.getNatureOfBusiness().equals(srchNature)
                && supplier.getManufacturingProcess().equals(srchProcess)){
                return supplier;
            }
        }
        return null;
    }

    public int getTotalManufacturers(String supplierId) {
        return this.totalManufacturersForSupId;
    }
    
}
