package com.revature.Project0.controllers;

import com.revature.Project0.models.Vendor;
import com.revature.Project0.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
