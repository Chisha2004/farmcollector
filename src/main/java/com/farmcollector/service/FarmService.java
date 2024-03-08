package com.farmcollector.service;

import com.farmcollector.dto.HarvestedDto;
import com.farmcollector.dto.PlantedDto;
import com.farmcollector.entity.Harvested;
import com.farmcollector.entity.Planted;

import java.util.List;

public interface FarmService {
    Planted savePlantation(PlantedDto plantedDto);
    Harvested saveHarvest(HarvestedDto harvestedDto);

    List<Harvested> getHarvests();
}
