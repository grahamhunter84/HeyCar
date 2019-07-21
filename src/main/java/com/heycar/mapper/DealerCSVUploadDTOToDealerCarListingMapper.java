package com.heycar.mapper;

import com.heycar.dto.DealerCSVUploadDTO;
import com.heycar.model.CarListing;
import com.heycar.model.DealerCarListing;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DealerCSVUploadDTOToDealerCarListingMapper {

  public static final String SPLIT = "/";

  public DealerCarListing from(long dealerId, DealerCSVUploadDTO dto) {
    List<String> makeAndModel = Arrays.asList(dto.getMakeAndModel().split(SPLIT));

    return new DealerCarListing(
        dealerId,
        new CarListing(
            makeAndModel.get(0),
            makeAndModel.get(1),
            null,
            dto.getColor(),
            dto.getPrice(),
            dto.getYear()
        ),
        dto.getCode());
  }
}
