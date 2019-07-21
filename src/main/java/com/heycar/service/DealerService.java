package com.heycar.service;

import com.heycar.model.CarListing;
import com.heycar.model.DealerCarListing;
import com.heycar.repository.DealerCarListingRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

  @Autowired
  private CarService carService;

  @Autowired
  private DealerCarListingRepository repository;

  @Transactional
  public void upload(List<DealerCarListing> uploadList) {
    //If one upload fails should the entire process fail?
    uploadList.stream().forEach(carListing -> {
          if (!repository.findByDealerIdAndListingId(carListing.getDealerId(), carListing.getListingId())
              .isPresent()) {
            create(carListing);
          } else {
            update(carListing);
          }
        }
    );
  }

  @Transactional
  private long create(DealerCarListing carListing) {
    carService.createCar(carListing.getCarListing());
    return repository.save(carListing).getId();
  }

  @Transactional
  private void update(DealerCarListing source) {
    Optional<DealerCarListing> existing = repository
        .findByDealerIdAndListingId(source.getDealerId(), source.getListingId());
    if (existing.isPresent()) {
      //We dont want to replace the entity because it will be wasteful, rather update fields
      DealerCarListing dealerCarListing = existing.get();
      CarListing sourceCar = source.getCarListing();
      CarListing targetListing = dealerCarListing.getCarListing();

      targetListing.setPrice(sourceCar.getPrice());
      targetListing.setModel(sourceCar.getModel());
      targetListing.setMake(sourceCar.getMake());
      targetListing.setKw(sourceCar.getKw());
      targetListing.setColor(sourceCar.getColor());
      targetListing.setYear(sourceCar.getYear());
      repository.save(dealerCarListing);
    }
  }
}
