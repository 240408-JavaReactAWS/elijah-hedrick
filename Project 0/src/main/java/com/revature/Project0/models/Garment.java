package com.revature.Project0.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "garment")
public class Garment {

    @Id // This marks a field as a primary key (unique identifier for each record)
    @Column(name = "itemId")// Like @Table, allows us to provide configuration details about the column itself'
    // We want the ID to generate itself so we'd want to use a tool built into the SQL DB like autoincrement or serial
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category")
    private String category;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "vendor")
    private String vendorName;

    public Garment() {
    }

    public Garment(String color, String size, String category, String vendorName) {
        this.color = color;
        this.size = size;
        this.category = category;
        this.vendorName = vendorName;
    }

    public Garment(int id, String color, String size, String category, String vendorName) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.category = category;
        this.vendorName = vendorName;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getCategory() {
        return category;
    }

    public String getvendorName() { return vendorName; }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVendor(String vendorName) { this.vendorName = vendorName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garment garment = (Garment) o;
        return id == garment.id && Objects.equals(category, garment.category) && Objects.equals(size, garment.size) && Objects.equals(color, garment.color) && Objects.equals(vendorName, garment.vendorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, size, color, vendorName);
    }

    @Override
    public String toString() {
        return "garment{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                "i, vendor=" + vendorName +
                '}';
    }

}
