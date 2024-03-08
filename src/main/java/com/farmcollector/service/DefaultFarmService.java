package com.farmcollector.service;

import com.farmcollector.dto.HarvestedDto;
import com.farmcollector.dto.PlantedDto;
import com.farmcollector.entity.Harvested;
import com.farmcollector.entity.Planted;
import com.farmcollector.repo.HarvestedRepo;
import com.farmcollector.repo.PlantedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class DefaultFarmService implements FarmService {

    PlantedRepo plantedRepo;

    HarvestedRepo harvestedRepo;

    @Override
    public Planted savePlantation(PlantedDto plantedDto) {

        Planted planted = new Planted();
        planted.setFarmName(plantedDto.farmName());
        planted.setSeason(plantedDto.season());
        planted.setArea(plantedDto.area());
        planted.setCropName(plantedDto.cropName());
        planted.setExpectedHarvest(plantedDto.expectedHarvest());

        plantedRepo.save(planted);

        return planted;
    }

    @Override
    public Harvested saveHarvest(HarvestedDto harvestedDto) {

        Optional<Planted> opPlanted = plantedRepo.findById(harvestedDto.plantedId());

        if(opPlanted.isEmpty()){
            throw new IllegalArgumentException(String.format("Cannot find plantation by id [%d]",
                    harvestedDto.plantedId()));
        }

        Harvested harvested = new Harvested();
        harvested.setHarvestAmount(harvestedDto.harvestAmount());
        harvested.setPlanted(opPlanted.get());

        return harvestedRepo.save(harvested);
    }

    @Override
    public List<Harvested> getHarvests() {

       return harvestedRepo.findAll();
    }

    @Autowired
    public void setPlantedRepo(PlantedRepo plantedRepo) {
        this.plantedRepo = plantedRepo;
    }

    @Autowired
    public void setHarvestedRepo(HarvestedRepo harvestedRepo) {
        this.harvestedRepo = harvestedRepo;
    }
}
