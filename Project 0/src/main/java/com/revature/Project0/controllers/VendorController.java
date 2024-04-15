package com.revature.Project0.controllers;

import com.revature.Project0.exceptions.GarmentNotFoundException;
import com.revature.Project0.exceptions.VendorNotFoundException;
import com.revature.Project0.models.Garment;
import com.revature.Project0.models.Vendor;
import com.revature.Project0.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vs) {
        this.vendorService = vs;
    }

    @PostMapping
    public Vendor registerVendorHandler(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping
    public Vendor loginVendorHandler(@RequestBody Vendor vendor) {
        return vendorService.loginAsVendor(vendor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Vendor> getVendorByIdHandler(@PathVariable int id) {
        Vendor vendor;
        try {
            vendor = vendorService.findVendorById(id);
        } catch (VendorNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(vendor, OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Vendor>> deleteVendorByIdHandler(@PathVariable int id) {
        try {
            vendorService.deleteVendorById(id);
        } catch (GarmentNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(this.getAllVendorsHandler(), OK);
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendorsHandler() {
        return vendorService.getAllVendors();
    }
}
