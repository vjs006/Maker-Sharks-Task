package com.api.models;

import java.util.List;

public class Supplier {
    private String supplier_id;
    private String company_name;
    private String website;
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcess;

    public Supplier(List<String> supDetails){
        this.supplier_id = supDetails.get(0);
        this.company_name = supDetails.get(1);
        this.website = supDetails.get(2);
        this.location = supDetails.get(3);
        this.natureOfBusiness = supDetails.get(4);
        this.manufacturingProcess = supDetails.get(5);
    }

    public Supplier(String supplier_id, String company_name, String website, String location, String natureOfBusiness,
            String ManufacturingProcess) {
        this.supplier_id = supplier_id;
        this.company_name = company_name;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcess = ManufacturingProcess;
    }
    
    public String getSupplier_id() {
        return supplier_id;
    }
    public String getCompany_name() {
        return company_name;
    }
    public String getWebsite() {
        return website;
    }
    public String getLocation() {
        return location;
    }
    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }
    public String getManufacturingProcess() {
        return manufacturingProcess;
    }

}
