package com.revature.Project0.services;


import com.revature.Project0.exceptions.GarmentNotFoundException;
import com.revature.Project0.exceptions.VendorNotFoundException;
import com.revature.Project0.models.Vendor;
import com.revature.Project0.repos.VendorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private VendorDAO vendorDAO;

    @Autowired
    public VendorService(VendorDAO vd){
        this.vendorDAO = vd;
    }

    public Vendor createVendor(Vendor vendor){
        return vendorDAO.save(vendor);
    }

    public Vendor loginAsVendor(Vendor vendor) {
        Vendor foundVendor = vendorDAO.findByVendorNameAndPassword(vendor.getVendorName(), vendor.getPassword());
        return vendorDAO.findById(foundVendor.getVendorId()).orElseThrow(()
                -> new VendorNotFoundException("!! Incorrect Vendor Name or Password !!"));
    }

}
