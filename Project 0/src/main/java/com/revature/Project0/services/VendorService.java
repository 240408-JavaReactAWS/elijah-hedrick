package com.revature.Project0.services;



import com.revature.Project0.exceptions.GarmentNotFoundException;
import com.revature.Project0.exceptions.VendorNotFoundException;
import com.revature.Project0.models.Garment;
import com.revature.Project0.models.Vendor;
import com.revature.Project0.repos.VendorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteVendorById(int id) {
        vendorDAO.delete(this.findVendorById(id));
        return; // to check if the item is successfully deleted
    }

    public Vendor findVendorById (int id) {
        return vendorDAO.findById(id).orElseThrow(() -> new VendorNotFoundException("No Vendor found with id: " + id));
    }

    public List<Vendor> getAllVendors(){
        // Now we call upon our DAO layer to get all of our users
        return vendorDAO.findAll();
    }
}
