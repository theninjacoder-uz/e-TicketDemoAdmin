package uz.pdp.eticketdemoadmin.model.recieve.station;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.pdp.eticketdemoadmin.model.recieve.address.AddressResponseDto;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationReceiveDto {
    private long id;
    private String name;
    private AddressResponseDto address;
}
