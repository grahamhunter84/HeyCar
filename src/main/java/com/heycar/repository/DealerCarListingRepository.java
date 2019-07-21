package com.heycar.repository;

import com.heycar.model.DealerCarListing;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerCarListingRepository extends CrudRepository<DealerCarListing, Long> {

  Optional<DealerCarListing> findByDealerIdAndListingId(long dealerId, String listingId);
}
