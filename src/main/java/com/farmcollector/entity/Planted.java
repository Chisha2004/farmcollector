package com.farmcollector.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Planted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="farm_name") //Would be nice to have farmId but here we are going to use farmName as farmId
    private String farmName;

    @Column
    private Long area;

    @Column(name="crop_name")
    private String cropName;

    @Column(name="expected_harvest")
    private Long expectedHarvest;

    @Column
    @Enumerated(value=EnumType.STRING)
    private Season season;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Long getExpectedHarvest() {
        return expectedHarvest;
    }

    public void setExpectedHarvest(Long expectedHarvest) {
        this.expectedHarvest = expectedHarvest;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
