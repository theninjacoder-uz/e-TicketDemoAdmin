package uz.pdp.eticketdemoadmin.model.recieve.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryReceiveDto {
    private long id;
    private String name;
    private Set<RegionReceiveDto> regionList;
}
