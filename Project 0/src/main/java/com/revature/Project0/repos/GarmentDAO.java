package com.revature.Project0.repos;

import com.revature.Project0.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.Project0.models.Garment;

import java.util.List;

public interface GarmentDAO extends JpaRepository<Garment, Integer> {

    Garment findClothesById(int id);
    List<Garment> findAllByVendorName(String vendorName);
}
