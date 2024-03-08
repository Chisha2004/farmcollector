package com.farmcollector.controller;


import com.farmcollector.dto.HarvestedDto;
import com.farmcollector.dto.PlantedDto;
import com.farmcollector.entity.Harvested;
import com.farmcollector.entity.Planted;
import com.farmcollector.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm/v1/plantation")
public class FarmController {

    FarmService farmService;

    /**
     * call this to give initial plantation
     * * * */
    @PostMapping(value = "/plant")
    public ResponseEntity<PlantedResponse> savePlanted(@RequestBody PlantedDto plantedDto) {

        Planted planted = farmService.savePlantation(plantedDto);
        PlantedResponse plantedResponse = new PlantedResponse(planted.getId());

        return ResponseEntity.ok(plantedResponse);
    }

    /**
     * call this with plantedId and the actual amount
     * * * */
    @PostMapping("/harvest")
    public ResponseEntity<HarvestedResponse> saveHarvested(@RequestBody HarvestedDto harvestedDto) {

        Harvested harvested = farmService.saveHarvest(harvestedDto);
        HarvestedResponse harvestedResponse = new HarvestedResponse(harvested.getId());

        return ResponseEntity.ok(harvestedResponse);
    }

    /**
     * This should return all the report for the farm and season
     * * * */
    @GetMapping("/report")
    public ResponseEntity<HarvestReports> getHarvestReport() {
        List<Harvested> harvests = farmService.getHarvests();

        HarvestReports harvestReports = new HarvestReports(harvests);

        return ResponseEntity.ok(harvestReports);
    }

    @Autowired
    public void setFarmService(FarmService farmService) {
        this.farmService = farmService;
    }
}
