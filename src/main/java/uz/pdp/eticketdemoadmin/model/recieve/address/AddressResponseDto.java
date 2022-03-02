package uz.pdp.eticketdemoadmin.model.recieve.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponseDto {
    private long id;
    private String streetName;
    private Integer homeNumber;
    private long regionId;
}
