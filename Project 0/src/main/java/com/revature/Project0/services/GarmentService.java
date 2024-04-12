package com.revature.Project0.services;

import com.revature.Project0.models.Garment;
import com.revature.Project0.models.Vendor;
import com.revature.Project0.repos.GarmentDAO;
import com.revature.Project0.exceptions.GarmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GarmentService {
    private GarmentDAO gd;
    private VendorService vs;

    @Autowired
    public GarmentService(GarmentDAO gd) {
        this.gd = gd;
    }

    public List<Garment> getAllGarments(){
        // Now we call upon our DAO layer to get all of our users
        return gd.findAll();
    }

    public Garment createGarment(Garment garment) {
        return gd.save(garment);
    }

    public Garment findGarmentById (int id) {
        return gd.findById(id).orElseThrow(() -> new GarmentNotFoundException("No Garment found with id: " + id));
    }

    public List<Garment> deleteGarmentById(int id) {
        gd.delete(this.findGarmentById(id));
        return this.getAllGarments(); // to check if the item is successfully deleted
    }

    public List<Garment> findGarmentByVendor (Vendor vendor) {
       // return gd.findAllByVendorName(vs.getVendor(vendor).getVendorName());
        return gd.findAllByVendorName(vendor.getVendorName());
    }

}
