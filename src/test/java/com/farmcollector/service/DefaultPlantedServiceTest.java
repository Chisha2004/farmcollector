package com.farmcollector.service;

import com.farmcollector.dto.PlantedDto;
import com.farmcollector.entity.Planted;
import com.farmcollector.entity.Season;
import com.farmcollector.repo.HarvestedRepo;
import com.farmcollector.repo.PlantedRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultPlantedServiceTest {
    @Mock
    PlantedRepo plantedRepo;
    @Mock
    HarvestedRepo harvestedRepo;

    @InjectMocks
    DefaultFarmService defaultPlantedService;


    @Test
    void givenAPlantation_whenRecordIsNewAndHasAllRequiredFields_thenExpectSaveAllFields() {

        PlantedDto plantedDto =
                new PlantedDto("MyFarm", 30L, "banana", 300L, Season.AUTUMN);

        when(plantedRepo.save(any())).thenReturn(returnsFirstArg());

        Planted planted = defaultPlantedService.savePlantation(plantedDto);

        assertEquals(plantedDto.farmName(), planted.getFarmName());
        assertEquals(plantedDto.area(), planted.getArea());
        assertEquals(plantedDto.cropName(), planted.getCropName());
        assertEquals(plantedDto.expectedHarvest(), planted.getExpectedHarvest());
        assertEquals(plantedDto.season(), planted.getSeason());

    }

}
