package com.farmcollector.controller;

import com.farmcollector.entity.Harvested;
import com.farmcollector.entity.Season;

public record HarvestReport(String farmName, Long area, Season season, Long expectedHarvest, Long actualHarvest) {

    public HarvestReport(Harvested harvested) {
        this(harvested.getPlanted().getFarmName(), harvested.getPlanted().getArea(),
                harvested.getPlanted().getSeason(), harvested.getPlanted().getExpectedHarvest() ,
                harvested.getHarvestAmount());
    }
}
