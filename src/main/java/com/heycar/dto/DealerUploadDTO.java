package com.heycar.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DealerUploadDTO implements Serializable {

  @NotEmpty
  String code;

  @NotEmpty
  String make;

  @NotEmpty
  String model;

  @NotNull
  Integer kW;

  @NotEmpty
  String color;

  @NotNull
  BigDecimal price;

  @NotNull
  Integer year;

  public DealerUploadDTO(String make,
      String model, Integer kW,
      String color, BigDecimal price,
      Integer year,
      String code) {
    this.make = make;
    this.model = model;
    this.kW = kW;
    this.color = color;
    this.price = price;
    this.year = year;
    this.code = code;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getkW() {
    return kW;
  }

  public void setkW(Integer kW) {
    this.kW = kW;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
