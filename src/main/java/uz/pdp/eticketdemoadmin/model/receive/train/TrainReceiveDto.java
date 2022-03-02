package uz.pdp.eticketdemoadmin.model.receive.train;

import lombok.Data;

@Data
public class TrainReceiveDto {

    private String name;
    private String model;
    private Integer capacity;
    private Integer availableSeatNumber;
    private double averageSpeed;
}
