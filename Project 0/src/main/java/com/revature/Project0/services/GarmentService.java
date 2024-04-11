package com.revature.Project0.services;

import com.revature.Project0.models.Garment;
import com.revature.Project0.repos.GarmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GarmentService {
    private GarmentDAO gd;

    @Autowired
    public GarmentService(GarmentDAO gd) {
        this.gd = gd;
    }

    public List<Garment> getAllGarments(){
        // Now we call upon our DAO layer to get all of our users
        return gd.findAll();
    }
}
