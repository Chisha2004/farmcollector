package com.farmcollector.controller;

import com.farmcollector.entity.Harvested;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class HarvestReports implements Serializable {

    private List<HarvestReport> harvestReportList;

    public HarvestReports(List<Harvested> harvestedList) {

        harvestReportList = harvestedList.stream().map(HarvestReport::new).collect(Collectors.toList());
    }

    public List<HarvestReport> getHarvestReportList() {
        return harvestReportList;
    }

    public void setHarvestReportList(List<HarvestReport> harvestReportList) {
        this.harvestReportList = harvestReportList;
    }
}
