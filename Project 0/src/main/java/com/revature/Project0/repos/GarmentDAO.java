package com.revature.Project0.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.Project0.models.Garment;

public interface GarmentDAO extends JpaRepository<Garment, Integer> {

    Garment findClothesById(int id);
}
