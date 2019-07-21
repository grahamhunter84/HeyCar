package com.heycar.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DealerCSVUploadDTO implements Serializable {

  @NotEmpty
  String code;

  @NotEmpty
  @JsonAlias("make/model")
  String makeAndModel;

  @NotEmpty
  @JsonAlias("power-in-ps")
  String power;

  @NotEmpty
  Integer year;

  @NotEmpty
  String color;

  @NotNull
  BigDecimal price;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPower() {
    return power;
  }

  public void setPower(String power) {
    this.power = power;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
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

  public String getMakeAndModel() {
    return makeAndModel;
  }

  public void setMakeAndModel(String makeAndModel) {
    this.makeAndModel = makeAndModel;
  }

}
