package uz.pdp.eticketdemoadmin.model.recieve.train;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainReceiveDto {
    private long id;
    private String name;
    private String model;
    private Integer capacity;
    private double averageSpeed;
}
