package com.heycar.controller;

import com.heycar.dto.CarListingDTO;
import com.heycar.model.CarListing;
import com.heycar.service.CarService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class CarListingController {

  @Autowired
  private CarService service;

  @GetMapping
  public Page search(
      @RequestParam(required = false) String make,
      @RequestParam(required = false) String model,
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) String color,
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {

    HashMap<String, Object> searchParams = new HashMap<>();
    if (make != null) {
      searchParams.put("make", make);
    }
    if (model != null) {
      searchParams.put("model", model);
    }
    if (year != null) {
      searchParams.put("year", year);
    }
    if (color != null) {
      searchParams.put("color", color);
    }

    Page<CarListing> result = service.find(searchParams, page, pageSize);
    return result.map(carListing ->
        new CarListingDTO(carListing.getMake(), carListing.getModel(), carListing.getKw(),
            carListing.getColor(), carListing.getPrice(), carListing.getYear()));

  }
}
