package uz.pdp.eticketdemoadmin.model.recieve.station;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.eticketdemoadmin.model.recieve.address.AddressResponseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationResponseDto {
    private long id;
    private String name;
    private AddressResponseDto address;
}
