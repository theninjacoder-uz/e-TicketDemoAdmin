package uz.pdp.eticketdemoadmin.model.recieve.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponseDto {
    private long id;
    private String streetName;
    private Integer homeNumber;
    private Long regionId;

    public AddressResponseDto(String streetName, Integer homeNumber, Long regionId) {
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.regionId = regionId;
    }
}
