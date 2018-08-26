package com.crossover.techtrial.repository;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.HourlyElectricity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * HourlyElectricity Repository is for all operations for HourlyElectricity.
 * @author Crossover
 */
@RestResource(exported = false)
public interface HourlyElectricityRepository 
    extends PagingAndSortingRepository<HourlyElectricity,Long> {
  Page<HourlyElectricity> findAllByPanelIdOrderByReadingAtDesc(Long panelId,Pageable pageable);

  @Query(value = "SELECT new com.crossover.techtrial.dto.DailyElectricity(" +
          " SUM(e.generatedElectricity) as sum, " +
          " AVG(e.generatedElectricity) as avg, " +
          " MAX(e.generatedElectricity) as max, " +
          " MIN(e.generatedElectricity) as min, " +
          "    DATE(e.readingAt) as date )" +
          "FROM " +
          " HourlyElectricity e left join e.panel p " +
          " where p.serial = :serial  " +
          " group by DATE(e.readingAt) ")
  List<DailyElectricity> getAllByLocalDate(@Param("serial") String serial);
}
