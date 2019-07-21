package com.heycar.repository.specification;

import com.heycar.model.CarListing;
import com.heycar.model.CarListing_;
import org.springframework.data.jpa.domain.Specification;

public class CarListingSpecification {


  public static Specification<CarListing> findByModel(Object model) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CarListing_.model), model);
  }

  public static Specification<CarListing> findByMake(Object make) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CarListing_.make), make);
  }

  public static Specification<CarListing> findByYear(Object year) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CarListing_.year), year);
  }

  public static Specification<CarListing> findByColour(Object colour) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CarListing_.color), colour);
  }

}
