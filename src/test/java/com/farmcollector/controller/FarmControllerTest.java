package com.farmcollector.controller;

import com.farmcollector.entity.Harvested;
import com.farmcollector.entity.Planted;
import com.farmcollector.service.FarmService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest(value = FarmControllerTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FarmControllerTest {

    @Autowired
    WebApplicationContext context;

    ObjectMapper objectMapper = new ObjectMapper();

    MockMvc mockMvc;

    @MockBean
    FarmService farmService;

    @BeforeEach
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    void givenAPlantation_whenAllFieldsProvided_expectSuccess() throws Exception {

        Planted planted = new Planted();
        planted.setId(1L);

        when(farmService.savePlantation(any())).thenReturn(planted);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/farm/v1/plantation/plant"))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andReturn();

        PlantedResponse plantedResponse =
                objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                        PlantedResponse.class );

        assertEquals(plantedResponse.plantedId(),planted.getId());

    }

    @Test
    void givenAHarvest_whenActualHarvestAmount_expectSuccess() throws Exception {

        Harvested harvested = new Harvested();
        harvested.setId(1L);
        Planted planted = new Planted();
        planted.setId(2L);

        harvested.setPlanted(planted);

        when(farmService.saveHarvest(any())).thenReturn(harvested);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/farm/v1/plantation/harvest"))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andReturn();

        HarvestedResponse harvestedResponse =
                objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                        HarvestedResponse.class );

        assertEquals(harvestedResponse.harvestedId(),harvested.getId());

    }
}
