package uz.pdp.eticketdemoadmin.model.receive.adress;

import lombok.Data;

@Data
public class AddressReceive {
    private int homeNumber;
    private String streetName;
    private long regionId;
}
