package com.heycar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DealerCarListing implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private long id;

  @Column
  private long dealerId;

  @OneToOne
  private CarListing carListing;

  @Column
  private String listingId;

  public DealerCarListing() {
  }

  public DealerCarListing(long dealerId, CarListing carListing, String listingId) {
    this.carListing = carListing;
    this.listingId = listingId;
    this.dealerId = dealerId;
  }

  public long getId() {
    return id;
  }

  public long getDealerId() {
    return dealerId;
  }

  public void setDealerId(long dealerId) {
    this.dealerId = dealerId;
  }

  public CarListing getCarListing() {
    return carListing;
  }

  public void setCarListing(CarListing carListing) {
    this.carListing = carListing;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }
}
