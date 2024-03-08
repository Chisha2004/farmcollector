package com.farmcollector.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Harvested {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planted_id", referencedColumnName = "id")
    private Planted planted;

    @Column(name="harvest_amount")
    private Long harvestAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planted getPlanted() {
        return planted;
    }

    public void setPlanted(Planted planted) {
        this.planted = planted;
    }

    public Long getHarvestAmount() {
        return harvestAmount;
    }

    public void setHarvestAmount(Long harvestAmount) {
        this.harvestAmount = harvestAmount;
    }
}
