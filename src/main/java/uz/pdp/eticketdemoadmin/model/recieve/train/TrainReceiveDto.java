package uz.pdp.eticketdemoadmin.model.recieve.train;

import lombok.Data;

@Data
public class TrainReceiveDto {

    private String name;
    private String model;
    private Integer capacity;
    private Integer availableSeatNumber;
    private double averageSpeed;
}
