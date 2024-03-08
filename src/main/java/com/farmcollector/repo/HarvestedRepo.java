package com.farmcollector.repo;

import com.farmcollector.entity.Harvested;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarvestedRepo extends JpaRepository<Harvested, Long> {
    @Query("SELECT h FROM Harvested AS h GROUP BY h.planted.farmName ORDER BY h.planted.season DESC")
    List<Harvested> findAll();
}
