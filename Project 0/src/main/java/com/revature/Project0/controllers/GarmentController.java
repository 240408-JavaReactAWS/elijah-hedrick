package com.revature.Project0.controllers;

import com.revature.Project0.models.Garment;
import com.revature.Project0.models.Vendor;
import com.revature.Project0.services.GarmentService;
import com.revature.Project0.exceptions.GarmentNotFoundException;
import com.revature.Project0.services.VendorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/garments")
public class GarmentController {
    private GarmentService gs;
    private VendorService vs;

    @Autowired
    public GarmentController(GarmentService gs, VendorService vs) {
        this.gs = gs; this.vs = vs;
    }

    @PostMapping
    public Garment createGarmentHandler(@RequestBody Garment garment) {
        return gs.createGarment(garment);
    }

    @GetMapping
    public List<Garment> getAllGarmentsHandler() {
        return gs.getAllGarments();
    }

    @GetMapping("{id}")
    public ResponseEntity<Garment> getGarmentByIdHandler(@PathVariable int id) {
        Garment garment;
        try {
            garment = gs.findGarmentById(id);
        } catch (GarmentNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(garment, OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Garment>> deleteGarmentByIdHandler(@PathVariable int id) {
        List<Garment> garments;
        try {
            garments = gs.deleteGarmentById(id);
        } catch (GarmentNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(garments, OK);
    }

    @GetMapping("/mygarments")
    public List<Garment> getAllMyGarmentsHandler(@RequestBody Vendor vendor) {
        vs.loginAsVendor(vendor);
        return gs.findGarmentByVendor(vendor);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Garment> patchGarmentHandler(@RequestBody Garment garment) {
        try {
            Garment g = gs.findGarmentById(garment.getId());
        } catch (GarmentNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(gs.updateGarment(garment), OK);
    }
}
