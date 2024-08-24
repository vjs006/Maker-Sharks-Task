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

    public SupplierService(){
        for (List<String> record: file1.getRecords()){
            supplierList.add(new Supplier(record));
        }
        for (List<String> record: file2.getRecords()){
            manufacturerList.add(new Manufacturer(record));
        }
    }

    public List<Manufacturer> getManufacturers(String supplierId) {
        List<Manufacturer> result = new ArrayList<Manufacturer>();
        String srchLocation = "";
        String srchNature = "";
        String srchProcess = "";
        for (Supplier supplier: supplierList){
            if (supplier.getSupplier_id().equals(supplierId)){
                srchLocation = supplier.getLocation();
                srchNature = supplier.getNatureOfBusiness();
                srchProcess = supplier.getManufacturingProcess();
            }
        }

        for (Manufacturer manufacturer: manufacturerList){
            if (manufacturer.getLocation().equals(srchLocation) 
                && manufacturer.getNatureOfBusiness().equals(srchNature)
                && manufacturer.getManufacturingProcess().equals(srchProcess)){
                result.add(manufacturer);
            }

        }
        return result;
    }

    public Supplier getSupplier(String supplierId) {
        for (Supplier supplier: supplierList){
            if (supplier.getSupplier_id().equals(supplierId)){
                return supplier;
            }
        }
        return null;
    }
    
}
