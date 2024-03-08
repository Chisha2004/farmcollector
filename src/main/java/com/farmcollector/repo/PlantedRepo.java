package com.farmcollector.repo;

import com.farmcollector.entity.Planted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantedRepo extends JpaRepository<Planted, Long> {
}
