package com.heycar.controller;

import com.heycar.dto.DealerUploadDTO;
import com.heycar.mapper.CSVToDealerDTOMapper;
import com.heycar.mapper.DealerCSVUploadDTOToDealerCarListingMapper;
import com.heycar.mapper.DealerUploadDTOToCarListingMapper;
import com.heycar.service.CarService;
import com.heycar.service.DealerService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DealerController {

  @Autowired
  private CarService uploadService;

  @Autowired
  private DealerService dealerService;

  @Autowired
  private DealerUploadDTOToCarListingMapper mapper;




  @Autowired
  private CSVToDealerDTOMapper dealerDTOMapper;




  @Autowired
  private DealerCSVUploadDTOToDealerCarListingMapper dealerListingMapper;


  @PostMapping(value = "/vehicle_listings/{dealerId}/")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@Valid @RequestBody List<DealerUploadDTO> uploadDTO,
      @PathVariable(required = true) Long dealerId) {
    dealerService.upload(uploadDTO.stream()
        .map(dealerCSVUploadDTO -> mapper.from(dealerId, dealerCSVUploadDTO))
        .collect(Collectors.toList()));
  }

  @PostMapping(value = "/upload_csv/{dealerId}/")
  @ResponseStatus(HttpStatus.CREATED)
  public void uploadViaCsv(
      @PathVariable(required = true) Long dealerId,
      @RequestParam("file") MultipartFile csv)
      throws IOException {

    dealerService.upload(dealerDTOMapper.from(csv).stream()
        .map(dealerCSVUploadDTO -> dealerListingMapper.from(dealerId, dealerCSVUploadDTO))
        .collect(Collectors.toList()));
  }
}
