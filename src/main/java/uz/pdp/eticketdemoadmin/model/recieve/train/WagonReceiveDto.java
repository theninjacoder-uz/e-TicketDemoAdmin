package uz.pdp.eticketdemoadmin.model.recieve.train;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.pdp.eticketdemoadmin.model.entity.train.TrainEntity;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WagonReceiveDto {
    private int number;

    private Integer capacity;

    private TrainEntity trainEntity;

    private Integer wagonType;
}
