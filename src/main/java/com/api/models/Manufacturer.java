package com.api.models;

import java.util.List;

public class Manufacturer {
    private String manufacturer_id;
    private String manufacturerName;
    private String contact;
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcess;

    public Manufacturer(List<String> manDetails){
        this.manufacturer_id = manDetails.get(0);
        this.manufacturerName = manDetails.get(1);
        this.contact = manDetails.get(2);
        this.location = manDetails.get(3);
        this.natureOfBusiness = manDetails.get(4);
        this.manufacturingProcess = manDetails.get(5);
    }
    
    public Manufacturer(String manufacturer_id, String manufacturerName, String contact, String location,
            String natureOfBusiness, String manufacturingProcess) {
        this.manufacturer_id = manufacturer_id;
        this.manufacturerName = manufacturerName;
        this.contact = contact;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcess = manufacturingProcess;
    }
    public String getManufacturer_id() {
        return manufacturer_id;
    }
    public String getManufacturerName() {
        return manufacturerName;
    }
    public String getContact() {
        return contact;
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
