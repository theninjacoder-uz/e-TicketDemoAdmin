package uz.pdp.eticketdemoadmin.model.receive.adress;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CountryReceive {
    private String country;
    private List<String> cities;
    private String iso3;

}
