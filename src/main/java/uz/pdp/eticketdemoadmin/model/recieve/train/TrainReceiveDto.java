package uz.pdp.eticketdemoadmin.model.recieve.train;

import lombok.Data;

@Data
public class TrainReceiveDto {
    private long id;
    private String name;
    private String model;
    private Integer capacity;
    private double averageSpeed;
}
