package com.farmcollector.dto;

import com.farmcollector.entity.Season;

public record PlantedDto (String farmName, Long area, String cropName, Long expectedHarvest, Season season){ }
