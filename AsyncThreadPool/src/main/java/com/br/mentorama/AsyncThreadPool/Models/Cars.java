package com.br.mentorama.AsyncThreadPool.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CARS")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String brand;
    @Column(nullable = false, length = 30)
    private String model;
    @Column(nullable = false, length = 7)
    private String plate;
    @Column(nullable = false, length = 4)
    private String manufactureYear;
    @Column(nullable = false, length = 4)
    private String businessYear;

    public Cars() {
    }

    public Cars(UUID id, String brand, String model, String plate, String manufactureYear, String business_year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.manufactureYear = manufactureYear;
        this.businessYear = business_year;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(String businessYear) {
        this.businessYear = businessYear;
    }
}
