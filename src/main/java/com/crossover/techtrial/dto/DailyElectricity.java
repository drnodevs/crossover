package com.crossover.techtrial.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * DailyElectricity class will hold sum, average,minimum and maximum electricity for a given day.
 * @author Crossover
 *
 */

public class DailyElectricity implements Serializable {
  
  private static final long serialVersionUID = 3605549122072628877L;

  public DailyElectricity(Long sum, Double average, Long min, Long max,java.util.Date date) {
    if(date !=null) {
      Instant instant = Instant.ofEpochMilli(date.getTime());
      this.date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }
    this.sum = sum;
    this.average = average;
    this.min = min;
    this.max = max;
  }

  private LocalDate date;
  
  private Long sum;
  
  private Double average;
  
  private Long min;
  
  private Long max;

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Long getSum() {
    return sum;
  }

  public void setSum(Long sum) {
    this.sum = sum;
  }

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

  public Long getMin() {
    return min;
  }

  public void setMin(Long min) {
    this.min = min;
  }

  public Long getMax() {
    return max;
  }

  public void setMax(Long max) {
    this.max = max;
  }

  @Override
  public String toString() {
    return "DailyElectricity [date=" + date + ", sum=" + sum + ", average="
        + average + ", min=" + min + ", max=" + max + "]";
  }

}
