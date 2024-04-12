package com.revature.Project0.repos;

import com.revature.Project0.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDAO extends JpaRepository<Vendor, Integer> {

    Vendor findByVendorName(String vendorName);
    Vendor findByVendorNameAndPassword(String vendorName, String password);
}
