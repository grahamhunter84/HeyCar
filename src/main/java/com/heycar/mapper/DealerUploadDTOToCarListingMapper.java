package com.heycar.mapper;

import com.heycar.dto.DealerUploadDTO;
import com.heycar.model.CarListing;
import com.heycar.model.DealerCarListing;
import org.springframework.stereotype.Component;

@Component
public class DealerUploadDTOToCarListingMapper {

  public DealerCarListing from(long dealerId, DealerUploadDTO dto) {
    return new DealerCarListing(
        dealerId,
        new CarListing(
            dto.getMake(),
            dto.getModel(),
            dto.getkW(),
            dto.getColor(),
            dto.getPrice(),
            dto.getYear()
        ),
        dto.getCode());
  }
}
