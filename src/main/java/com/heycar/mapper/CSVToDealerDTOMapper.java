package com.heycar.mapper;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.heycar.dto.DealerCSVUploadDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CSVToDealerDTOMapper {

  public List<DealerCSVUploadDTO> from(MultipartFile csv) throws IOException {
    CsvMapper csvMapper = new CsvMapper();
    CsvSchema schema = CsvSchema.emptySchema().withHeader();

    ObjectReader oReader = csvMapper.reader(DealerCSVUploadDTO.class).with(schema);

    List<DealerCSVUploadDTO> result = new ArrayList<>();
    try (Reader reader = new FileReader(convertMultiPartToFile(csv))) {
      MappingIterator<DealerCSVUploadDTO> mi = oReader.readValues(reader);
      while (mi.hasNext()) {
        result.add(mi.next());
      }
    }
    return result;
  }

  private File convertMultiPartToFile(MultipartFile file ) throws IOException
  {
    File convFile = new File( "temp");
    FileOutputStream fos = new FileOutputStream( convFile);
    fos.write( file.getBytes() );
    fos.close();
    return convFile;
  }
}
