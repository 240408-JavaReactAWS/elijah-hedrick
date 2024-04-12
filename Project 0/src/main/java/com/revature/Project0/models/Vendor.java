package com.revature.Project0.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id // Annotation to declare the following data as PK
    @Column(name = "vendorId") // Column name for the following data
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To automatically generate and increment the following data
    private int vendorId;

    @Column(name = "vendorName", unique = true)
    private String vendorName;
    @Column(name = "password")
    private String password;

    // no-args constructor
    public Vendor() {
    }

    public Vendor(String vendorName, String password) {
        this.vendorName = vendorName;
        this.password = password;
    }
    // all-args constructor
    public Vendor(int vendorId, String vendorName, String password) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.password = password;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return getVendorId() == vendor.getVendorId() && Objects.equals(getVendorName(), vendor.getVendorName()) && Objects.equals(getPassword(), vendor.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVendorId(), getVendorName(), getPassword());
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
