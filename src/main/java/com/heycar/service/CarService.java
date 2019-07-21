package com.heycar.service;

import com.heycar.model.CarListing;
import com.heycar.repository.CarListingRepository;
import com.heycar.repository.specification.CarListingSpecification;
import java.util.HashMap;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  private CarListingRepository repository;


  @Transactional
  public Long createCar(CarListing carListing) {
    CarListing saved = repository.save(carListing);

    return saved.getId();
  }

  @Transactional
  public void updateCar(CarListing source) {
    Optional<CarListing> optionalExisting = repository.findById(source.getId());

    if (optionalExisting.isPresent()) {
      CarListing existing = optionalExisting.get();
      existing.setColor(source.getColor());
      existing.setKw(source.getKw());
      existing.setMake(source.getMake());
      existing.setModel(source.getModel());
      existing.setPrice(source.getPrice());
    } else {
      throw new EntityNotFoundException("Car not found");
    }
  }


  @Transactional
  public Page<CarListing> find(HashMap<String, Object> searchParams, int page, int pageSize) {

    if (searchParams.isEmpty()) {
      return repository.findAll(new PageRequest(page, pageSize));
    }

    Specification<CarListing> spec = null;
    if (searchParams.containsKey("make")) {
      Specification<CarListing> byParam = CarListingSpecification
          .findByMake(searchParams.get("make"));
      spec = spec != null ? spec.and(byParam) : byParam;
    }
    if (searchParams.containsKey("model")) {
      Specification<CarListing> byParam = CarListingSpecification
          .findByModel(searchParams.get("model"));
      spec = spec != null ? spec.and(byParam) : byParam;
    }
    if (searchParams.containsKey("year")) {
      Specification<CarListing> byParam = CarListingSpecification
          .findByYear(searchParams.get("year"));
      spec = spec != null ? spec.and(byParam) : byParam;
    }
    if (searchParams.containsKey("color")) {
      Specification<CarListing> byParam = CarListingSpecification
          .findByColour(searchParams.get("color"));
      spec = spec != null ? spec.and(byParam) : byParam;
    }

    return spec != null ? repository.findAll(spec, new PageRequest(page, pageSize))
        : repository.findAll(new PageRequest(page, pageSize));
  }

  public Optional<CarListing> get(long id) {
    return repository.findById(id);
  }
}
