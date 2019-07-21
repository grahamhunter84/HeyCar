package com.heycar.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarListing implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private long id;

  @Column
  String make;

  @Column
  String model;

  @Column
  Integer kw;

  @Column
  String color;

  @Column
  BigDecimal price;

  @Column
  Integer year;

  public CarListing() {

  }


  public CarListing(String make, String model, Integer kw, String color, BigDecimal price,
      Integer year) {
    this.make = make;
    this.model = model;
    this.kw = kw;
    this.color = color;
    this.price = price;
    this.year = year;
  }

  public long getId() {
    return id;
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

  public Integer getKw() {
    return kw;
  }

  public void setKw(Integer kw) {
    this.kw = kw;
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
}
