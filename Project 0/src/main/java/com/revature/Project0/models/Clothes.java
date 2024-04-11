package com.revature.Project0.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clothes")
public class Clothes {

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

    public Clothes() {
    }

    public Clothes(String color, String size, String category) {
        this.color = color;
        this.size = size;
        this.category = category;
    }

    public Clothes(int id, String color, String size, String category) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return id == clothes.id && Objects.equals(category, clothes.category) && Objects.equals(size, clothes.size) && Objects.equals(color, clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, size, color);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
