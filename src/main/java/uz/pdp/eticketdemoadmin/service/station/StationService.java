package uz.pdp.eticketdemoadmin.service.station;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.eticketdemoadmin.model.receive.adress.CountryReceive;
import uz.pdp.eticketdemoadmin.response.ApiResponse;

@Service
@RequiredArgsConstructor
public class StationService {
    private String CITIES_URL = "https://countriesnow.space/api/v0.1/countries";
    public final ObjectMapper objectMapper;
    public final RestTemplate restTemplate;
    public void chooseCountry(){
        CountryReceive countryReceive = restTemplate.getForObject(CITIES_URL, CountryReceive.class);

    }
}
